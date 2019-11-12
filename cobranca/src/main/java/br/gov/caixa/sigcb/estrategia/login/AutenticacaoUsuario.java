package br.gov.caixa.sigcb.estrategia.login;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.UsuLogadoBean;
import br.gov.caixa.sigcb.estrategia.Sessao;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.ldap.AcessoLdap;
import br.gov.caixa.sigcb.ldap.Perfil;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Login. Responsavel por
 * recuperar atributos(dados) do LDAP conforme login do usuario.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class AutenticacaoUsuario extends SigcbEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configura Bean de Sucesso/Erro
        configMsgSucessoErro(request);

        // Obtem perfil do usuario no LDAP: utilizado para obter
        // InformacoesUsuario
       // PerfilUsuario perfilUsuario = ComponenteLdap.getPerfilUsuario("SIGCB", request);
        
        Perfil perfilUsuario = null;
        AcessoLdap acessoLdap = new AcessoLdap();
        try {
        	String user = request.getRemoteUser();
        	//user="c899838";
        	perfilUsuario = acessoLdap.consultarPerfil(user);
        	
        } catch (Exception e) {
        	 throw new SigcbException(new Exception("Erro ao acessar ComponenteLdap ou Usuário não logado."));
        }
        
        // Obtem userGroup (grupo ldap): define as restricoes do usuario
        String userGroup = "";
        /*
        if (perfilUsuario == null)
            throw new SigcbException(new Exception("Perfil 'SIGCB' no LDAP não cadastrado"));
        else if (perfilUsuario.permiteOperacao("GCBMAS")) {
            userGroup = "GCBMAS";
        } else if (perfilUsuario.permiteOperacao("GCBADM")) {
            userGroup = "GCBADM";
        } else if (perfilUsuario.permiteOperacao("GCBDIR")) {
            userGroup = "GCBDIR";
        } else if (perfilUsuario.permiteOperacao("GCBGER")) {
            userGroup = "GCBGER";
        } else if (perfilUsuario.permiteOperacao("GCBRET")) {
            userGroup = "GCBRET";
        } else if (perfilUsuario.permiteOperacao("GCBREC")) {
            userGroup = "GCBREC";
        } else if (perfilUsuario.permiteOperacao("GCBOPE")) {
            userGroup = "GCBOPE";
        } else if (perfilUsuario.permiteOperacao("GCBINC")) {
            userGroup = "GCBINC";
        } else if (perfilUsuario.permiteOperacao("GCBSEC")) {
            userGroup = "GCBSEC";
        } else if (perfilUsuario.permiteOperacao("GCBATI")) {
            userGroup = "GCBATI";
        } else if (perfilUsuario.permiteOperacao("GCBATE")) {
            userGroup = "GCBATE";
        } else if (perfilUsuario.permiteOperacao("GCBAUD")) {// SISOL 147829
            userGroup = "GCBAUD";
        } else if (perfilUsuario.permiteOperacao("GCBTCX")) {// SISOL 231078
            userGroup = "GCBTCX";
        } else if (perfilUsuario.permiteOperacao("GCBTEC")) {
            userGroup = "GCBTEC";
        } else if (perfilUsuario.permiteOperacao("GCBPAB")) {
            userGroup = "GCBPAB";
        } else if (perfilUsuario.permiteOperacao("GCBCON")) {
            userGroup = "GCBCON";
        } else if (perfilUsuario.permiteOperacao("GCBCEN")) {
            userGroup = "GCBCEN";
        } else if (perfilUsuario.permiteOperacao("GCBDDA")) {
            userGroup = "GCBDDA"; 
        } else if (perfilUsuario.permiteOperacao("GCBAET")) {
            userGroup = "GCBAET"; 
        } else if (perfilUsuario.permiteOperacao("GCBAIT")) {
            userGroup = "GCBAIT";
        } else if (perfilUsuario.permiteOperacao("GCBSRE")) {
            userGroup = "GCBSRE";
        } else if (perfilUsuario.permiteOperacao("GCBSRE1")) {
            userGroup = "GCBSRE1";    
        } else if (perfilUsuario.permiteOperacao("GCBSRE2")) {
            userGroup = "GCBSRE2";
        } else if (perfilUsuario.permiteOperacao("GCBSRE3")) {
            userGroup = "GCBSRE3";
        } else if (perfilUsuario.permiteOperacao("GCBAUD1")) {
            userGroup = "GCBAUD1";
        } else if (perfilUsuario.permiteOperacao("GCBAIT1")) {
            userGroup = "GCBAIT1";
        } else if (perfilUsuario.permiteOperacao("GCBOPE1")) {
            userGroup = "GCBOPE1";
        } else if (perfilUsuario.permiteOperacao("GCBOPE2")) {
            userGroup = "GCBOPE2";
        } else if (perfilUsuario.permiteOperacao("GCBGER1")) {
            userGroup = "GCBGER1";
        } else {
            throw new SigcbException(new Exception("Usuário não possui acesso às funcões do sistema"));
        }
		*/
        
        userGroup = perfilUsuario.getGrupo();
        
        
        // Obtem InformacoersUsuario: define atributos do usuario
        /*InformacoesUsuarioBean usuario = getInformacoesUsuarioLdap(perfilUsuario, userGroup);
        if (usuario == null) {
            LogUtilSigcb.error("INFORMAÇÕES SOBRE O USUÁRIO NO LDAP NÃO ENCONTRADAS!");
        }
        */
        InformacoesUsuarioBean usuario = new InformacoesUsuarioBean();
        usuario.setCodigoUsuario(perfilUsuario.getCoUsuario());
        usuario.setNomeGrupo(userGroup);
        usuario.setCodigoUnidade(perfilUsuario.getNuUnidade());
        
        request.getSession().setAttribute(USUARIOLDAP_BEAN, usuario);
        //SigcbEstrategia.COD_USUARIO = usuario.getUsername().toUpperCase();
        //SigcbEstrategia.COD_USUARIO = "C053605";  //Alterado em 18/09 de C068114 -> C053605
        SigcbEstrategia.COD_USUARIO = "NOUSER";  //Alterado em 14/09/2018 --> Baby solicitou problemas de seguranca

       
        if (LogUtilSigcb.isInfoEnabled()) {
            StringBuffer sb = new StringBuffer();
            sb.append("Usuario ")
                    .append(usuario.getUsername())
                    .append(" efetuou logon em ")
                    .append(Calendar.getInstance().getTime());
            sb.append("\n====Informacoes sobre o Usuario===");
            sb.append("\n-User Group............= ").append(userGroup);
            sb.append("\n-Username..............= ")
                    .append(usuario.getUsername());
            sb.append("\n-UID...................= ").append(usuario.getUid());
            sb.append("\n-NomeUsuario...........= ")
                    .append(usuario.getNomeUsuario());
            sb.append("\n-CodigoUsuario.........= ")
                    .append(usuario.getCodigoUsuario());
            sb.append("\n-NomeCargo.............= ")
                    .append(usuario.getNomeCargo());
            sb.append("\n-CodigoCargo...........= ")
                    .append(usuario.getCodigoCargo());
            sb.append("\n-NomeFuncao............= ")
                    .append(usuario.getNomeFuncao());
            sb.append("\n-Codigofuncao..........= ")
                    .append(usuario.getCodigoFuncao());
            sb.append("\n-NomeUnidade...........= ")
                    .append(usuario.getNomeUnidade());
            sb.append("\n-CodigoUnidade.........= ")
                    .append(usuario.getCodigoUnidade());
            sb.append("\n-NumeroCPF.............= ")
                    .append(usuario.getNumeroCpf());
            sb.append("\n-NomeEmpresa...........= ")
                    .append(usuario.getNomeEmpresa());
            sb.append("\n-NumeroCNPJ............= ")
                    .append(usuario.getNumeroCnpj());
            sb.append("\n-CodigoUnidadeSub......= ")
                    .append(usuario.getCodigoUnidadeSub());
            sb.append("\n-Descricao.............= ")
                    .append(usuario.getDescricao());
            sb.append("\n-Fax...................= ").append(usuario.getFax());
            sb.append("\n-Email.................= ").append(usuario.getEmail());
            sb.append("\n-Celular...............= ")
                    .append(usuario.getCelular());
            sb.append("\n-Pager.................= ").append(usuario.getPager());
            sb.append("\n-Departamento..........= ")
                    .append(usuario.getDepartamento());
            sb.append("\n-Cep...................= ").append(usuario.getCep());
            sb.append("\n-Uf....................= ").append(usuario.getUf());
            sb.append("\n-Rua...................= ").append(usuario.getRua());
            sb.append("\n-Telefone..............= ")
                    .append(usuario.getTelefone());
            sb.append("\n-Title.................= ").append(usuario.getTitle());
            sb.append("\n-DtNascimento..........= ")
                    .append(usuario.getDtNascimento());
            sb.append("\n-CodigoLotacaoFisica...= ")
                    .append(usuario.getCodigoLotacaoFisica());
            sb.append("\n-NomeLotacaoFisica.....= ")
                    .append(usuario.getNomeLotacaoFisica());
            sb.append("\n-UfLotacaoFisica.......= ")
                    .append(usuario.getUfLotacaoFisica());
            sb.append("\n-SgUnidade.............= ")
                    .append(usuario.getSgUnidade());
            sb.append("\n-CodigoTpUnidade.......= ")
                    .append(usuario.getCodigoTpUnidade());
            LogUtilSigcb.info(sb.toString());
        }

        return "sigcb_logo";
    }

    private InformacoesUsuarioBean getInformacoesUsuarioLdap(Perfil perfil,
            String nivelAcesso) {
        InformacoesUsuarioBean informacoesUsuario = new InformacoesUsuarioBean();

        informacoesUsuario.setNomeGrupo(nivelAcesso);

        /*
        informacoesUsuario.setUsername(perfil.getUsername());
        informacoesUsuario.setUid(perfil.getUid());
        informacoesUsuario.setNomeUsuario(perfil.getNoUsuario());
        informacoesUsuario.setCodigoUsuario(perfil.getCoUsuario());
        informacoesUsuario.setNomeCargo(perfil.getNoCargo());
        informacoesUsuario.setCodigoCargo(perfil.getCoCargo());
        informacoesUsuario.setNomeFuncao(perfil.getNoFuncao());
        informacoesUsuario.setCodigoFuncao(perfil.getCoFuncao());
        informacoesUsuario.setNomeUnidade(perfil.getNoUnidade());
        informacoesUsuario.setCodigoUnidade(perfil.getNuUnidade());
        informacoesUsuario.setNumeroCpf(perfil.getNuCpf());
        informacoesUsuario.setNomeEmpresa(perfil.getNoEmpresa());
        informacoesUsuario.setNumeroCnpj(perfil.getNuCnpj());
        informacoesUsuario.setCodigoUnidadeSub(perfil.getNuUnidadeSub());
        informacoesUsuario.setDescricao(perfil.getDescription());
        informacoesUsuario.setFax(perfil.getFacSimileTelephoneNumber());
        informacoesUsuario.setEmail(perfil.getMail());
        informacoesUsuario.setCelular(perfil.getMobile());
        informacoesUsuario.setPager(perfil.getPager());
        informacoesUsuario.setDepartamento(perfil.getPhysicalDeliveryOfficeName());
        informacoesUsuario.setCep(perfil.getPostalCode());
        informacoesUsuario.setUf(perfil.getSt());
        informacoesUsuario.setRua(perfil.getStreet());
        informacoesUsuario.setTelefone(perfil.getTelephoneNumber());
        informacoesUsuario.setTitle(perfil.getTitle());

        informacoesUsuario.setDtNascimento(perfil.getDtNascimento());
        informacoesUsuario.setCodigoLotacaoFisica(perfil.getNuLotacaoFisica());
        informacoesUsuario.setNomeLotacaoFisica(perfil.getNoLotacaoFisica());
        informacoesUsuario.setUfLotacaoFisica(perfil.getUfLotacaoFisica());
        informacoesUsuario.setSgUnidade("AAAA");
        informacoesUsuario.setCodigoTpUnidade("111");
        */
        // informacoesUsuario.setSgUnidade(perfil.getSgUnidade());
        // informacoesUsuario.setCodigoTpUnidade(perfil.getNuTpUnidade());

        return informacoesUsuario;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        request.getSession().setAttribute("msgBean", msgBean);
    }

    public String getCustomizedHTMLMessagePageName() {
        return "sigcb_erro";
    }
}