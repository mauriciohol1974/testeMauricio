package br.com.politec.sao.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Em sistemas que precisam converter de forma eficiente números e objetos em
 * uma representação textual, é necessário que o paradigma de converter os
 * valores necessários como uma <code>String</code> e concatená-los seja
 * abandonado, pois essa conversão pode não ser eficiente, além dela gerar
 * muitos objetos intermediários. Numa arquitetura de <code>Appendable</code>s
 * e <code>Appender</code>, cada objeto deve saber como se escrever num
 * objeto escritor, e esse objeto escritor é passado para os objetos se
 * escreverem e ele sabe como escrever valores primitivos. Essa classe
 * representa um objeto escritor otimizado que possui os métodos necessários
 * para escrever tipos primitivos e objetos de forma eficiente, utilizando um
 * objeto do tipo <code>java.io.Writer</code> como fonte de saída do que ele
 * escreve. Os métodos para escrever <code>float</code>s e
 * <code>double</code>s não estão plenamento otimizados, ainda, ou seja ainda
 * existem laços que podem ser desenrolados e chamadas de métodos que podem ser
 * evitadas. Todos os métodos são <code>final</code> para otimizar as chamadas
 * dos métodos, pois desse modo a máquina virtual sabe sempre que essas chamadas
 * nunca são polimórficas. Caso em futuras edições do Java&copy; surjam
 * conversões otimizadas de números, então essa classe pode ser alterada para
 * apenas repassar as chamadas ás conversões-padrão.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 * @see Appendable
 * @see StringAppender
 */
public class Appender extends OutputStream {
    /**
     * Conjunto de caracteres de LF e CR que formam um fim de linha independente
     * de plataforma.
     */
    public static final String NEW_LINE = "\r\n";

    /**
     * Valor padrão de TAB.
     */
    public static final String TAB = "    ";

    /**
     * <code>Array</code> que armazena versões de caracteres para cada dígito.
     */
    private static final char[] charForDigit = {
                                                '0',
                                                '1',
                                                '2',
                                                '3',
                                                '4',
                                                '5',
                                                '6',
                                                '7',
                                                '8',
                                                '9' };

    /**
     * <code>Array</code> qeu armazena as magnitude de um <code>float</float>.
     */
    private static final float[] f_magnitudes = {
                                                 1e-44F,
                                                 1e-43F,
                                                 1e-42F,
                                                 1e-41F,
                                                 1e-40F,
                                                 1e-39F,
                                                 1e-38F,
                                                 1e-37F,
                                                 1e-36F,
                                                 1e-35F,
                                                 1e-34F,
                                                 1e-33F,
                                                 1e-32F,
                                                 1e-31F,
                                                 1e-30F,
                                                 1e-29F,
                                                 1e-28F,
                                                 1e-27F,
                                                 1e-26F,
                                                 1e-25F,
                                                 1e-24F,
                                                 1e-23F,
                                                 1e-22F,
                                                 1e-21F,
                                                 1e-20F,
                                                 1e-19F,
                                                 1e-18F,
                                                 1e-17F,
                                                 1e-16F,
                                                 1e-15F,
                                                 1e-14F,
                                                 1e-13F,
                                                 1e-12F,
                                                 1e-11F,
                                                 1e-10F,
                                                 1e-9F,
                                                 1e-8F,
                                                 1e-7F,
                                                 1e-6F,
                                                 1e-5F,
                                                 1e-4F,
                                                 1e-3F,
                                                 1e-2F,
                                                 1e-1F,
                                                 1e0F,
                                                 1e1F,
                                                 1e2F,
                                                 1e3F,
                                                 1e4F,
                                                 1e5F,
                                                 1e6F,
                                                 1e7F,
                                                 1e8F,
                                                 1e9F,
                                                 1e10F,
                                                 1e11F,
                                                 1e12F,
                                                 1e13F,
                                                 1e14F,
                                                 1e15F,
                                                 1e16F,
                                                 1e17F,
                                                 1e18F,
                                                 1e19F,
                                                 1e20F,
                                                 1e21F,
                                                 1e22F,
                                                 1e23F,
                                                 1e24F,
                                                 1e25F,
                                                 1e26F,
                                                 1e27F,
                                                 1e28F,
                                                 1e29F,
                                                 1e30F,
                                                 1e31F,
                                                 1e32F,
                                                 1e33F,
                                                 1e34F,
                                                 1e35F,
                                                 1e36F,
                                                 1e37F,
                                                 1e38F };

    /**
     * <code>Array</code> que armazena as magnitudes de um <code>double</code>.
     */
    private static final double[] d_magnitudes = {
                                                  1e-323D,
                                                  1e-322D,
                                                  1e-321D,
                                                  1e-320D,
                                                  1e-319D,
                                                  1e-318D,
                                                  1e-317D,
                                                  1e-316D,
                                                  1e-315D,
                                                  1e-314D,
                                                  1e-313D,
                                                  1e-312D,
                                                  1e-311D,
                                                  1e-310D,
                                                  1e-309D,
                                                  1e-308D,
                                                  1e-307D,
                                                  1e-306D,
                                                  1e-305D,
                                                  1e-304D,
                                                  1e-303D,
                                                  1e-302D,
                                                  1e-301D,
                                                  1e-300D,
                                                  1e-299D,
                                                  1e-298D,
                                                  1e-297D,
                                                  1e-296D,
                                                  1e-295D,
                                                  1e-294D,
                                                  1e-293D,
                                                  1e-292D,
                                                  1e-291D,
                                                  1e-290D,
                                                  1e-289D,
                                                  1e-288D,
                                                  1e-287D,
                                                  1e-286D,
                                                  1e-285D,
                                                  1e-284D,
                                                  1e-283D,
                                                  1e-282D,
                                                  1e-281D,
                                                  1e-280D,
                                                  1e-279D,
                                                  1e-278D,
                                                  1e-277D,
                                                  1e-276D,
                                                  1e-275D,
                                                  1e-274D,
                                                  1e-273D,
                                                  1e-272D,
                                                  1e-271D,
                                                  1e-270D,
                                                  1e-269D,
                                                  1e-268D,
                                                  1e-267D,
                                                  1e-266D,
                                                  1e-265D,
                                                  1e-264D,
                                                  1e-263D,
                                                  1e-262D,
                                                  1e-261D,
                                                  1e-260D,
                                                  1e-259D,
                                                  1e-258D,
                                                  1e-257D,
                                                  1e-256D,
                                                  1e-255D,
                                                  1e-254D,
                                                  1e-253D,
                                                  1e-252D,
                                                  1e-251D,
                                                  1e-250D,
                                                  1e-249D,
                                                  1e-248D,
                                                  1e-247D,
                                                  1e-246D,
                                                  1e-245D,
                                                  1e-244D,
                                                  1e-243D,
                                                  1e-242D,
                                                  1e-241D,
                                                  1e-240D,
                                                  1e-239D,
                                                  1e-238D,
                                                  1e-237D,
                                                  1e-236D,
                                                  1e-235D,
                                                  1e-234D,
                                                  1e-233D,
                                                  1e-232D,
                                                  1e-231D,
                                                  1e-230D,
                                                  1e-229D,
                                                  1e-228D,
                                                  1e-227D,
                                                  1e-226D,
                                                  1e-225D,
                                                  1e-224D,
                                                  1e-223D,
                                                  1e-222D,
                                                  1e-221D,
                                                  1e-220D,
                                                  1e-219D,
                                                  1e-218D,
                                                  1e-217D,
                                                  1e-216D,
                                                  1e-215D,
                                                  1e-214D,
                                                  1e-213D,
                                                  1e-212D,
                                                  1e-211D,
                                                  1e-210D,
                                                  1e-209D,
                                                  1e-208D,
                                                  1e-207D,
                                                  1e-206D,
                                                  1e-205D,
                                                  1e-204D,
                                                  1e-203D,
                                                  1e-202D,
                                                  1e-201D,
                                                  1e-200D,
                                                  1e-199D,
                                                  1e-198D,
                                                  1e-197D,
                                                  1e-196D,
                                                  1e-195D,
                                                  1e-194D,
                                                  1e-193D,
                                                  1e-192D,
                                                  1e-191D,
                                                  1e-190D,
                                                  1e-189D,
                                                  1e-188D,
                                                  1e-187D,
                                                  1e-186D,
                                                  1e-185D,
                                                  1e-184D,
                                                  1e-183D,
                                                  1e-182D,
                                                  1e-181D,
                                                  1e-180D,
                                                  1e-179D,
                                                  1e-178D,
                                                  1e-177D,
                                                  1e-176D,
                                                  1e-175D,
                                                  1e-174D,
                                                  1e-173D,
                                                  1e-172D,
                                                  1e-171D,
                                                  1e-170D,
                                                  1e-169D,
                                                  1e-168D,
                                                  1e-167D,
                                                  1e-166D,
                                                  1e-165D,
                                                  1e-164D,
                                                  1e-163D,
                                                  1e-162D,
                                                  1e-161D,
                                                  1e-160D,
                                                  1e-159D,
                                                  1e-158D,
                                                  1e-157D,
                                                  1e-156D,
                                                  1e-155D,
                                                  1e-154D,
                                                  1e-153D,
                                                  1e-152D,
                                                  1e-151D,
                                                  1e-150D,
                                                  1e-149D,
                                                  1e-148D,
                                                  1e-147D,
                                                  1e-146D,
                                                  1e-145D,
                                                  1e-144D,
                                                  1e-143D,
                                                  1e-142D,
                                                  1e-141D,
                                                  1e-140D,
                                                  1e-139D,
                                                  1e-138D,
                                                  1e-137D,
                                                  1e-136D,
                                                  1e-135D,
                                                  1e-134D,
                                                  1e-133D,
                                                  1e-132D,
                                                  1e-131D,
                                                  1e-130D,
                                                  1e-129D,
                                                  1e-128D,
                                                  1e-127D,
                                                  1e-126D,
                                                  1e-125D,
                                                  1e-124D,
                                                  1e-123D,
                                                  1e-122D,
                                                  1e-121D,
                                                  1e-120D,
                                                  1e-119D,
                                                  1e-118D,
                                                  1e-117D,
                                                  1e-116D,
                                                  1e-115D,
                                                  1e-114D,
                                                  1e-113D,
                                                  1e-112D,
                                                  1e-111D,
                                                  1e-110D,
                                                  1e-109D,
                                                  1e-108D,
                                                  1e-107D,
                                                  1e-106D,
                                                  1e-105D,
                                                  1e-104D,
                                                  1e-103D,
                                                  1e-102D,
                                                  1e-101D,
                                                  1e-100D,
                                                  1e-99D,
                                                  1e-98D,
                                                  1e-97D,
                                                  1e-96D,
                                                  1e-95D,
                                                  1e-94D,
                                                  1e-93D,
                                                  1e-92D,
                                                  1e-91D,
                                                  1e-90D,
                                                  1e-89D,
                                                  1e-88D,
                                                  1e-87D,
                                                  1e-86D,
                                                  1e-85D,
                                                  1e-84D,
                                                  1e-83D,
                                                  1e-82D,
                                                  1e-81D,
                                                  1e-80D,
                                                  1e-79D,
                                                  1e-78D,
                                                  1e-77D,
                                                  1e-76D,
                                                  1e-75D,
                                                  1e-74D,
                                                  1e-73D,
                                                  1e-72D,
                                                  1e-71D,
                                                  1e-70D,
                                                  1e-69D,
                                                  1e-68D,
                                                  1e-67D,
                                                  1e-66D,
                                                  1e-65D,
                                                  1e-64D,
                                                  1e-63D,
                                                  1e-62D,
                                                  1e-61D,
                                                  1e-60D,
                                                  1e-59D,
                                                  1e-58D,
                                                  1e-57D,
                                                  1e-56D,
                                                  1e-55D,
                                                  1e-54D,
                                                  1e-53D,
                                                  1e-52D,
                                                  1e-51D,
                                                  1e-50D,
                                                  1e-49D,
                                                  1e-48D,
                                                  1e-47D,
                                                  1e-46D,
                                                  1e-45D,
                                                  1e-44D,
                                                  1e-43D,
                                                  1e-42D,
                                                  1e-41D,
                                                  1e-40D,
                                                  1e-39D,
                                                  1e-38D,
                                                  1e-37D,
                                                  1e-36D,
                                                  1e-35D,
                                                  1e-34D,
                                                  1e-33D,
                                                  1e-32D,
                                                  1e-31D,
                                                  1e-30D,
                                                  1e-29D,
                                                  1e-28D,
                                                  1e-27D,
                                                  1e-26D,
                                                  1e-25D,
                                                  1e-24D,
                                                  1e-23D,
                                                  1e-22D,
                                                  1e-21D,
                                                  1e-20D,
                                                  1e-19D,
                                                  1e-18D,
                                                  1e-17D,
                                                  1e-16D,
                                                  1e-15D,
                                                  1e-14D,
                                                  1e-13D,
                                                  1e-12D,
                                                  1e-11D,
                                                  1e-10D,
                                                  1e-9D,
                                                  1e-8D,
                                                  1e-7D,
                                                  1e-6D,
                                                  1e-5D,
                                                  1e-4D,
                                                  1e-3D,
                                                  1e-2D,
                                                  1e-1D,
                                                  1e0D,
                                                  1e1D,
                                                  1e2D,
                                                  1e3D,
                                                  1e4D,
                                                  1e5D,
                                                  1e6D,
                                                  1e7D,
                                                  1e8D,
                                                  1e9D,
                                                  1e10D,
                                                  1e11D,
                                                  1e12D,
                                                  1e13D,
                                                  1e14D,
                                                  1e15D,
                                                  1e16D,
                                                  1e17D,
                                                  1e18D,
                                                  1e19D,
                                                  1e20D,
                                                  1e21D,
                                                  1e22D,
                                                  1e23D,
                                                  1e24D,
                                                  1e25D,
                                                  1e26D,
                                                  1e27D,
                                                  1e28D,
                                                  1e29D,
                                                  1e30D,
                                                  1e31D,
                                                  1e32D,
                                                  1e33D,
                                                  1e34D,
                                                  1e35D,
                                                  1e36D,
                                                  1e37D,
                                                  1e38D,
                                                  1e39D,
                                                  1e40D,
                                                  1e41D,
                                                  1e42D,
                                                  1e43D,
                                                  1e44D,
                                                  1e45D,
                                                  1e46D,
                                                  1e47D,
                                                  1e48D,
                                                  1e49D,
                                                  1e50D,
                                                  1e51D,
                                                  1e52D,
                                                  1e53D,
                                                  1e54D,
                                                  1e55D,
                                                  1e56D,
                                                  1e57D,
                                                  1e58D,
                                                  1e59D,
                                                  1e60D,
                                                  1e61D,
                                                  1e62D,
                                                  1e63D,
                                                  1e64D,
                                                  1e65D,
                                                  1e66D,
                                                  1e67D,
                                                  1e68D,
                                                  1e69D,
                                                  1e70D,
                                                  1e71D,
                                                  1e72D,
                                                  1e73D,
                                                  1e74D,
                                                  1e75D,
                                                  1e76D,
                                                  1e77D,
                                                  1e78D,
                                                  1e79D,
                                                  1e80D,
                                                  1e81D,
                                                  1e82D,
                                                  1e83D,
                                                  1e84D,
                                                  1e85D,
                                                  1e86D,
                                                  1e87D,
                                                  1e88D,
                                                  1e89D,
                                                  1e90D,
                                                  1e91D,
                                                  1e92D,
                                                  1e93D,
                                                  1e94D,
                                                  1e95D,
                                                  1e96D,
                                                  1e97D,
                                                  1e98D,
                                                  1e99D,
                                                  1e100D,
                                                  1e101D,
                                                  1e102D,
                                                  1e103D,
                                                  1e104D,
                                                  1e105D,
                                                  1e106D,
                                                  1e107D,
                                                  1e108D,
                                                  1e109D,
                                                  1e110D,
                                                  1e111D,
                                                  1e112D,
                                                  1e113D,
                                                  1e114D,
                                                  1e115D,
                                                  1e116D,
                                                  1e117D,
                                                  1e118D,
                                                  1e119D,
                                                  1e120D,
                                                  1e121D,
                                                  1e122D,
                                                  1e123D,
                                                  1e124D,
                                                  1e125D,
                                                  1e126D,
                                                  1e127D,
                                                  1e128D,
                                                  1e129D,
                                                  1e130D,
                                                  1e131D,
                                                  1e132D,
                                                  1e133D,
                                                  1e134D,
                                                  1e135D,
                                                  1e136D,
                                                  1e137D,
                                                  1e138D,
                                                  1e139D,
                                                  1e140D,
                                                  1e141D,
                                                  1e142D,
                                                  1e143D,
                                                  1e144D,
                                                  1e145D,
                                                  1e146D,
                                                  1e147D,
                                                  1e148D,
                                                  1e149D,
                                                  1e150D,
                                                  1e151D,
                                                  1e152D,
                                                  1e153D,
                                                  1e154D,
                                                  1e155D,
                                                  1e156D,
                                                  1e157D,
                                                  1e158D,
                                                  1e159D,
                                                  1e160D,
                                                  1e161D,
                                                  1e162D,
                                                  1e163D,
                                                  1e164D,
                                                  1e165D,
                                                  1e166D,
                                                  1e167D,
                                                  1e168D,
                                                  1e169D,
                                                  1e170D,
                                                  1e171D,
                                                  1e172D,
                                                  1e173D,
                                                  1e174D,
                                                  1e175D,
                                                  1e176D,
                                                  1e177D,
                                                  1e178D,
                                                  1e179D,
                                                  1e180D,
                                                  1e181D,
                                                  1e182D,
                                                  1e183D,
                                                  1e184D,
                                                  1e185D,
                                                  1e186D,
                                                  1e187D,
                                                  1e188D,
                                                  1e189D,
                                                  1e190D,
                                                  1e191D,
                                                  1e192D,
                                                  1e193D,
                                                  1e194D,
                                                  1e195D,
                                                  1e196D,
                                                  1e197D,
                                                  1e198D,
                                                  1e199D,
                                                  1e200D,
                                                  1e201D,
                                                  1e202D,
                                                  1e203D,
                                                  1e204D,
                                                  1e205D,
                                                  1e206D,
                                                  1e207D,
                                                  1e208D,
                                                  1e209D,
                                                  1e210D,
                                                  1e211D,
                                                  1e212D,
                                                  1e213D,
                                                  1e214D,
                                                  1e215D,
                                                  1e216D,
                                                  1e217D,
                                                  1e218D,
                                                  1e219D,
                                                  1e220D,
                                                  1e221D,
                                                  1e222D,
                                                  1e223D,
                                                  1e224D,
                                                  1e225D,
                                                  1e226D,
                                                  1e227D,
                                                  1e228D,
                                                  1e229D,
                                                  1e230D,
                                                  1e231D,
                                                  1e232D,
                                                  1e233D,
                                                  1e234D,
                                                  1e235D,
                                                  1e236D,
                                                  1e237D,
                                                  1e238D,
                                                  1e239D,
                                                  1e240D,
                                                  1e241D,
                                                  1e242D,
                                                  1e243D,
                                                  1e244D,
                                                  1e245D,
                                                  1e246D,
                                                  1e247D,
                                                  1e248D,
                                                  1e249D,
                                                  1e250D,
                                                  1e251D,
                                                  1e252D,
                                                  1e253D,
                                                  1e254D,
                                                  1e255D,
                                                  1e256D,
                                                  1e257D,
                                                  1e258D,
                                                  1e259D,
                                                  1e260D,
                                                  1e261D,
                                                  1e262D,
                                                  1e263D,
                                                  1e264D,
                                                  1e265D,
                                                  1e266D,
                                                  1e267D,
                                                  1e268D,
                                                  1e269D,
                                                  1e270D,
                                                  1e271D,
                                                  1e272D,
                                                  1e273D,
                                                  1e274D,
                                                  1e275D,
                                                  1e276D,
                                                  1e277D,
                                                  1e278D,
                                                  1e279D,
                                                  1e280D,
                                                  1e281D,
                                                  1e282D,
                                                  1e283D,
                                                  1e284D,
                                                  1e285D,
                                                  1e286D,
                                                  1e287D,
                                                  1e288D,
                                                  1e289D,
                                                  1e290D,
                                                  1e291D,
                                                  1e292D,
                                                  1e293D,
                                                  1e294D,
                                                  1e295D,
                                                  1e296D,
                                                  1e297D,
                                                  1e298D,
                                                  1e299D,
                                                  1e300D,
                                                  1e301D,
                                                  1e302D,
                                                  1e303D,
                                                  1e304D,
                                                  1e305D,
                                                  1e306D,
                                                  1e307D,
                                                  1e308D };

    /**
     * <code>Array</code> que armazena arrays contendo sequências de zeros.
     */
    public static final char[][] ZEROS = {
                                          {},
                                          { '0' },
                                          { '0', '0' },
                                          { '0', '0', '0' },
                                          { '0', '0', '0', '0' },
                                          { '0', '0', '0', '0', '0' },
                                          { '0', '0', '0', '0', '0', '0' },
                                          { '0', '0', '0', '0', '0', '0', '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' },
                                          {
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0',
                                           '0' }, };

    /**
     * <code>Array</code> que armazena os caracteres da palavra "null".
     */
    private static final char[] NULL = { 'n', 'u', 'l', 'l' };

    /**
     * <code>Array</code> que armazena os caracteres da palavra "true".
     */
    private static final char[] TRUE = { 't', 'r', 'u', 'e' };

    /**
     * <code>Array</code> que armazena os caracteres da palavra "false".
     */
    private static final char[] FALSE = { 'f', 'a', 'l', 's', 'e' };

    /**
     * Representa o caracter "[", mas na forma de um <code>int</code>.
     */
    private static final int OPEN_LIST = '[';

    /**
     * Representa o caracter "]", mas na forma de um <code>int</code>.
     */
    private static final int CLOSE_LIST = ']';

    /**
     * <code>Array</code> que armazena os caracteres ", ".
     */
    private static final char[] SEPARATOR = { ',', ' ' };

    /**
     * <code>Array</code> que armazena os caracteres " -> ".
     */
    private static final char[] KEY_MAPS_VALUE = { ' ', '-', '>', ' ' };

    /**
     * <code>Array</code> que armazena o caracter " " (espaço).
     */
    private static final char SPACE = ' ';

    /**
     * <code>Array</code> que armazena os caracteres da palavra "-Infinity".
     */
    private static final char[] NEGATIVE_INFINITY = {
                                                     '-',
                                                     'I',
                                                     'n',
                                                     'f',
                                                     'i',
                                                     'n',
                                                     'i',
                                                     't',
                                                     'y' };

    /**
     * <code>Array</code> que armazena os caracteres da palavra "Infinity".
     */
    private static final char[] POSITIVE_INFINITY = {
                                                     'I',
                                                     'n',
                                                     'f',
                                                     'i',
                                                     'n',
                                                     'i',
                                                     't',
                                                     'y' };

    /**
     * <code>Array</code> que armazena os caracteres da palavra "NaN".
     */
    private static final char[] NaN = { 'N', 'a', 'N' };

    /**
     * <code>Array</code> que armazena os caracteres "0.0".
     */
    private static final char[] DOUBLE_ZERO = { '0', '.', '0' };

    /**
     * <code>Array</code> que armazena os caracteres "0.00".
     */
    private static final char[] DOUBLE_ZERO2 = { '0', '.', '0', '0' };

    /**
     * <code>Array</code> que armazena os caracteres "0.".
     */
    private static final char[] DOUBLE_ZERO0 = { '0', '.' };

    /**
     * <code>Array</code> que armazena os caracteres ".0".
     */
    private static final char[] DOT_ZERO = { '.', '0' };

    /**
     * Utilizado para obter o sinal de um <code>double</code>.
     */
    private static final long doubleSignMask = 0x8000000000000000L;

    /**
     * Utilizado para obter o expoente de um <code>double</code>.
     */
    private static final long doubleExpMask = 0x7ff0000000000000L;

    /**
     * Utilizado para obter a parte fracionária de um <code>double</code>.
     */
    private static final long doubleFractMask = ~(doubleSignMask | doubleExpMask);

    /**
     * Utilizado para obter dados do expoente de um <code>double</code>.
     */
    private static final int doubleExpShift = 52;

    /**
     * Utilizado para obter dados do expoente de um <code>double</code>.
     */
    private static final int doubleExpBias = 1023;

    /**
     * Utilizado para obter o sinal de um <code>float</code>.
     */
    private static final int floatSignMask = 0x80000000;

    /**
     * Utilizado para obter o expoente de um <code>float</code>.
     */
    private static final int floatExpMask = 0x7f800000;

    /**
     * Utilizado para obter a parte fracionária de um <code>dfloat</code>.
     */
    private static final int floatFractMask = ~(floatSignMask | floatExpMask);

    /**
     * Utilizado para obter dados do expoente de um <code>float</code>.
     */
    private static final int floatExpShift = 23;

    /**
     * Utilizado para obter dados do expoente de um <code>float</code>.
     */
    private static final int floatExpBias = 127;

    /**
     * Constrói um novo <code>Appender</code> que irá utilizar o
     * <code>Writer</code> informado como canal de saída de dados.
     * 
     * @param writer
     *            objeto de escrita de dados a ser utilizado
     * @requires writer != null : "Writer não pode ser nulo"
     */
    public Appender(java.io.Writer writer) {
        Assertions.requires(writer != null, "Writer não pode ser nulo");
        this.writer = writer;
    }

    /**
     * Fecha o objeto de escrita e impede que ele seja utilizado.
     */
    public final void close() throws IOException {
        this.writer.close();
    }

    /**
     * Escreve um <code>byte</code>.
     * 
     * @param b
     *            <code>byte</code> à ser escrito
     */
    public final void write(int b) throws IOException {
        this.writer.write(b);
    }

    /**
     * Escreve um <code>array</code> de <code>byte</code>s.
     * 
     * @param bytes
     *            <code>array</code> de <code>byte</code>s à ser escrito
     */
    public final void write(byte[] bytes) throws IOException {
        this.append(bytes);
    }

    /**
     * Escreve <i>length</i> bytes do <code>array</code> <code>bytes</code>
     * á partir da posição <i>offset</i>.
     * 
     * @param bytes
     *            <code>array</code> de <code>byte</code>s à ser escrito
     * @param offset
     *            posição inicial do <code>array</code>
     * @param length
     *            número de bytes à ser escrito
     */
    public final void write(byte[] bytes, int offset, int length)
            throws IOException {
        this.append(bytes, offset, length);
    }

    /**
     * Efetua um <i>flush</i> no objeto de escrita associado
     * 
     * @throws IOException
     *             caso ocorra um erro durante o <i>flush</i>
     */
    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final Appender newLine() throws IOException {
        return append(NEW_LINE);
    }

    public final Appender tab() throws IOException {
        return append(TAB);
    }

    /**
     * Escreve um conjunto de bytes na saída associada.
     * 
     * @param dados
     *            à serem escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(byte[] dados) throws IOException {
        this.writer.write(new String(dados));
        return this;
    }

    /**
     * Escreve um conjunto de caracteres na saída associada.
     * 
     * @param dados
     *            à serem escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(char[] dados) throws IOException {
        this.writer.write(dados);
        return this;
    }

    /**
     * Escreve um subconjunto de um conjunto de bytes na saída associada.
     * 
     * @param dados
     *            à serem escrito
     * @param inicio
     *            início do subconjunto de bytes a ser considerado
     * @param tamanho
     *            do subconjunto
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(byte[] dados, int inicio, int tamanho)
            throws IOException {
        this.writer.write(new String(dados, inicio, tamanho));
        return this;
    }

    /**
     * Escreve um subconjunto de um conjunto de caracteres na saída associada.
     * 
     * @param dados
     *            à serem escrito
     * @param inicio
     *            início do subconjunto de caracteres a ser considerado
     * @param tamanho
     *            do subconjunto
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(char[] dados, int inicio, int tamanho)
            throws IOException {
        this.writer.write(dados, inicio, tamanho);
        return this;
    }

    /**
     * Escreve um número na saída associada.
     * 
     * @param numero
     *            número à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(long numero) throws IOException {
        if (numero < 0) {
            if (numero == Long.MIN_VALUE) {
                writer.write("-9223372036854775808");
                return this;
            } else {
                writer.write('-');
                numero = -numero;
            }
        }
        if (numero < 10L) { // 1 dígito
            writer.write(charForDigit[(int) numero]);
        } else if (numero < 100L) { // 2 dígitos
            writer.write(charForDigit[(int) (numero / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 1000L) { // 3 dígitos
            writer.write(charForDigit[(int) (numero / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 10000L) { // 4 dígitos
            writer.write(charForDigit[(int) (numero / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 100000L) { // 5 dígitos
            writer.write(charForDigit[(int) (numero / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 1000000L) { // 6 dígitos
            writer.write(charForDigit[(int) (numero / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 10000000L) { // 7 dígitos
            writer.write(charForDigit[(int) (numero / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 100000000L) { // 8 dígitos
            writer.write(charForDigit[(int) (numero / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 1000000000L) { // 9 dígitos
            writer.write(charForDigit[(int) (numero / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 10000000000L) { // 10 dígitos
            writer.write(charForDigit[(int) (numero / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 100000000000L) { // 11 dígitos
            writer.write(charForDigit[(int) (numero / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 1000000000000L) { // 12 dígitos
            writer.write(charForDigit[(int) (numero / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 10000000000000L) { // 13 dígitos
            writer.write(charForDigit[(int) (numero / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 100000000000000L) { // 14 dígitos
            writer.write(charForDigit[(int) (numero / 10000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000L) / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 1000000000000000L) { // 15 dígitos
            writer.write(charForDigit[(int) (numero / 100000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000L) / 10000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000L) / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 10000000000000000L) { // 16 dígitos
            writer.write(charForDigit[(int) (numero / 1000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000000L) / 100000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000L) / 10000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000L) / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 100000000000000000L) { // 17 dígitos
            writer.write(charForDigit[(int) (numero / 10000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000000L) / 1000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000000L) / 100000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000L) / 10000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000L) / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else if (numero < 1000000000000000000L) { // 18 dígitos
            writer.write(charForDigit[(int) (numero / 100000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000000L) / 10000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000000L) / 1000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000000L) / 100000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000L) / 10000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000L) / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        } else { // 19 dígitos
            writer.write(charForDigit[(int) (numero / 1000000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000000000L) / 100000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000000L) / 10000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000000L) / 1000000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000000L) / 100000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000000L) / 10000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000000L) / 1000000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000000L) / 100000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000000L) / 10000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000000L) / 1000000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000000L) / 100000000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000000L) / 10000000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000000L) / 1000000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000000L) / 100000L)]);
            writer.write(charForDigit[(int) ((numero %= 100000L) / 10000L)]);
            writer.write(charForDigit[(int) ((numero %= 10000L) / 1000L)]);
            writer.write(charForDigit[(int) ((numero %= 1000L) / 100L)]);
            writer.write(charForDigit[(int) ((numero %= 100L) / 10L)]);
            writer.write(charForDigit[(int) (numero % 10L)]);
        }
        return this;
    }

    /**
     * Escreve um número na saída associada.
     * 
     * @param numero
     *            número à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(int numero) throws IOException {
        if (numero < 0) {
            if (numero == Integer.MIN_VALUE) {
                writer.write("-2147483648");
                return this;
            } else {
                writer.write('-');
                numero = -numero;
            }
        }
        if (numero < 10) { // 1 dígito
            writer.write(charForDigit[numero]);
        } else if (numero < 100) { // 2 dígitos
            writer.write(charForDigit[numero / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 1000) { // 3 dígitos
            writer.write(charForDigit[numero / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 10000) { // 4 dígitos
            writer.write(charForDigit[numero / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 100000) { // 5 dígitos
            writer.write(charForDigit[numero / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 1000000) { // 6 dígitos
            writer.write(charForDigit[numero / 100000]);
            writer.write(charForDigit[(numero %= 100000) / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 10000000) { // 7 dígitos
            writer.write(charForDigit[numero / 1000000]);
            writer.write(charForDigit[(numero %= 1000000) / 100000]);
            writer.write(charForDigit[(numero %= 100000) / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 100000000) { // 8 dígitos
            writer.write(charForDigit[numero / 10000000]);
            writer.write(charForDigit[(numero %= 10000000) / 1000000]);
            writer.write(charForDigit[(numero %= 1000000) / 100000]);
            writer.write(charForDigit[(numero %= 100000) / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 1000000000) { // 9 dígitos
            writer.write(charForDigit[numero / 100000000]);
            writer.write(charForDigit[(numero %= 100000000) / 10000000]);
            writer.write(charForDigit[(numero %= 10000000) / 1000000]);
            writer.write(charForDigit[(numero %= 1000000) / 100000]);
            writer.write(charForDigit[(numero %= 100000) / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else { // 10 dígitos
            writer.write(charForDigit[numero / 1000000000]);
            writer.write(charForDigit[(numero %= 1000000000) / 100000000]);
            writer.write(charForDigit[(numero %= 100000000) / 10000000]);
            writer.write(charForDigit[(numero %= 10000000) / 1000000]);
            writer.write(charForDigit[(numero %= 1000000) / 100000]);
            writer.write(charForDigit[(numero %= 100000) / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        }
        return this;
    }

    /**
     * Escreve um caracter na saída associada.
     * 
     * @param caracter
     *            caracter à ser escrito
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(char caracter) throws IOException {
        writer.write(caracter);
        return this;
    }

    /**
     * Escreve um número na saída associada.
     * 
     * @param numero
     *            número à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(short numero) throws IOException {
        if (numero < 0) {
            if (numero == Short.MIN_VALUE) {
                writer.write("-32768");
                return this;
            } else {
                writer.write('-');
                numero = (short) -numero;
            }
        }
        if (numero < 10) { // 1 dígito
            writer.write(charForDigit[numero]);
        } else if (numero < 100) { // 2 dígitos
            writer.write(charForDigit[numero / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 1000) { // 3 dígitos
            writer.write(charForDigit[numero / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else if (numero < 10000) { // 4 dígitos
            writer.write(charForDigit[numero / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        } else { // 5 dígitos
            writer.write(charForDigit[numero / 10000]);
            writer.write(charForDigit[(numero %= 10000) / 1000]);
            writer.write(charForDigit[(numero %= 1000) / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        }
        return this;
    }

    /**
     * Escreve um número na saída associada.
     * 
     * @param numero
     *            número à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(byte numero) throws IOException {
        if (numero < 0) {
            if (numero == Byte.MIN_VALUE) {
                writer.write("-128");
                return this;
            } else {
                writer.write('-');
                numero = (byte) -numero;
            }
        }
        if (numero < 10) { // 1 dígito
            writer.write(charForDigit[numero]);
        } else if (numero < 100) { // 2 dígitos
            writer.write(charForDigit[numero / 10]);
            writer.write(charForDigit[numero % 10]);
        } else { // 3 dígitos
            writer.write(charForDigit[numero / 100]);
            writer.write(charForDigit[(numero %= 100) / 10]);
            writer.write(charForDigit[numero % 10]);
        }
        return this;
    }

    /**
     * Escreve um <code>boolean</code> na saída associada.
     * 
     * @param booleano
     *            <code>boolean</code> à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(boolean booleano) throws IOException {
        if (booleano) {
            writer.write(TRUE);
        } else {
            writer.write(FALSE);
        }
        return this;
    }

    /**
     * Escreve um número na saída associada.
     * 
     * @param numero
     *            número à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(float numero) throws IOException {
        if (numero == Float.NEGATIVE_INFINITY) {
            writer.write(NEGATIVE_INFINITY);
        } else if (numero == Float.POSITIVE_INFINITY) {
            writer.write(POSITIVE_INFINITY);
        } else if (numero != numero) {
            writer.write(NaN);
        } else if (numero == 0.0) {
            if ((Float.floatToIntBits(numero) & floatSignMask) != 0) {
                writer.write('-');
            }
            writer.write(DOUBLE_ZERO);
        } else {
            if (numero < 0) {
                writer.write('-');
                numero = -numero;
            }
            if (numero >= 0.001F && numero < 0.01F) {
                long i = (long) (numero * 1E12F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                writer.write(DOUBLE_ZERO2);
                appendFractDigits(i, -1);
            } else if (numero >= 0.01F && numero < 0.1F) {
                long i = (long) (numero * 1E11F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                writer.write(DOUBLE_ZERO);
                appendFractDigits(i, -1);
            } else if (numero >= 0.1F && numero < 1F) {
                long i = (long) (numero * 1E10F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                writer.write(DOUBLE_ZERO0);
                appendFractDigits(i, -1);
            } else if (numero >= 1F && numero < 10F) {
                long i = (long) (numero * 1E9F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 1);
            } else if (numero >= 10F && numero < 100F) {
                long i = (long) (numero * 1E8F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 2);
            } else if (numero >= 100F && numero < 1000F) {
                long i = (long) (numero * 1E7F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 3);
            } else if (numero >= 1000F && numero < 10000F) {
                long i = (long) (numero * 1E6F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 4);
            } else if (numero >= 10000F && numero < 100000F) {
                long i = (long) (numero * 1E5F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 5);
            } else if (numero >= 100000F && numero < 1000000F) {
                long i = (long) (numero * 1E4F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 6);
            } else if (numero >= 1000000F && numero < 10000000F) {
                long i = (long) (numero * 1E3F);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 7);
            } else {
                int magnitude = magnitude(numero);
                long i;
                if (magnitude < -35) {
                    i = (long) ((numero * 1E10F) / f_magnitudes[magnitude + 45]);
                } else {
                    i = (long) (numero / f_magnitudes[magnitude + 44 - 9]);
                }
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 1);
                writer.write('E');
                append(magnitude);
            }
        }
        return this;
    }

    /**
     * Escreve um número na saída associada.
     * 
     * @param numero
     *            número à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(double numero) throws IOException {
        if (numero == Double.NEGATIVE_INFINITY) {
            writer.write(NEGATIVE_INFINITY);
        } else if (numero == Double.POSITIVE_INFINITY) {
            writer.write(POSITIVE_INFINITY);
        } else if (numero != numero) {
            writer.write(NaN);
        } else if (numero == 0.0) {
            if ((Double.doubleToLongBits(numero) & doubleSignMask) != 0) {
                writer.write('-');
            }
            writer.write(DOUBLE_ZERO);
        } else {
            if (numero < 0) {
                writer.write('-');
                numero = -numero;
            }
            if (numero >= 0.001 && numero < 0.01) {
                long i = (long) (numero * 1E20);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                writer.write(DOUBLE_ZERO2);
                appendFractDigits(i, -1);
            } else if (numero >= 0.01 && numero < 0.1) {
                long i = (long) (numero * 1E19);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                writer.write(DOUBLE_ZERO);
                appendFractDigits(i, -1);
            } else if (numero >= 0.1 && numero < 1) {
                long i = (long) (numero * 1E18);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                writer.write(DOUBLE_ZERO0);
                appendFractDigits(i, -1);
            } else if (numero >= 1 && numero < 10) {
                long i = (long) (numero * 1E17);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 1);
            } else if (numero >= 10 && numero < 100) {
                long i = (long) (numero * 1E16);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 2);
            } else if (numero >= 100 && numero < 1000) {
                long i = (long) (numero * 1E15);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 3);
            } else if (numero >= 1000 && numero < 10000) {
                long i = (long) (numero * 1E14);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 4);
            } else if (numero >= 10000 && numero < 100000) {
                long i = (long) (numero * 1E13);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 5);
            } else if (numero >= 100000 && numero < 1000000) {
                long i = (long) (numero * 1E12);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 6);
            } else if (numero >= 1000000 && numero < 10000000) {
                long i = (long) (numero * 1E11);
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 7);
            } else {
                int magnitude = magnitude(numero);
                long i;
                if (magnitude < -305) {
                    i = (long) (numero * 1E18 / d_magnitudes[magnitude + 324]);
                } else {
                    i = (long) (numero / d_magnitudes[magnitude + 323 - 17]);
                }
                i = (i % 100 >= 50) ? ((i / 100) + 1) : (i / 100);
                appendFractDigits(i, 1);
                writer.write((int) 'E');
                append(magnitude);
            }
        }
        return this;
    }

    /**
     * Escreve um objeto qualquer na saída associada. Caso seja um objeto que o
     * <code>Appender</code> consiga tratar de maneira mais específica, ele
     * redireciona o processamento para o método mais específico.
     * 
     * @param obj
     *            objeto à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(Object obj) throws IOException {
        if (obj == null) {
            writer.write(NULL);
        } else if (obj instanceof Appendable) {
            append((Appendable) obj);
        } else if (obj instanceof Throwable) {
            append((Throwable) obj);
        } else if (obj instanceof java.util.List) {
            append((java.util.List) obj);
        } else if (obj instanceof java.util.Map) {
            append((java.util.Map) obj);
        } else if (obj instanceof java.util.Map.Entry) {
            append((java.util.Map.Entry) obj);
        } else {
            writer.write(obj.toString());
        }
        return this;
    }

    /**
     * Escreve um erro ocorrido na saída associada.
     * 
     * @param exc
     *            erro á ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(Throwable exc) throws IOException {
        append(exc.toString());
        append(NEW_LINE);
        // exc.printStackTrace(new PrintStream(this));
        StringWriter strWriter = new StringWriter();
        PrintWriter prnWriter = new PrintWriter(strWriter);
        exc.printStackTrace(prnWriter);
        prnWriter.close();
        strWriter.close();
        append(strWriter);
        LogUtilSigcb.error("Erro:" + exc.toString(), exc);
        return this;
    }

    /**
     * Escreve uma lista na saída associada. Ele escreve "[" em seguida cada
     * elemento da lista, separados por ", " e por fim escreve "]". Trata cada
     * elemento da lista com os métodos específicos dele mesmo, podendo então
     * escrever listas de listas.
     * 
     * @param lista
     *            lista à ser escrita
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(java.util.List lista) throws IOException {
        if (lista == null) {
            writer.write(NULL);
        } else {
            final int size = lista.size();
            writer.write(OPEN_LIST);
            if (size > 0) {
                append(lista.get(0));
            }
            for (int i = 1; i < size; i++) {
                writer.write(SEPARATOR);
                append(lista.get(i));
            }
            writer.write(CLOSE_LIST);
        }
        return this;
    }

    /**
     * Escreve uma entrada de mapa na saída associada. Escreve a chave, seguido
     * do símbolo de mapeamento " -> " e por fim escreve o valor. Escreve ambos
     * com os seus métodos mais específicos, de modo a poder lidar com uma
     * entrada que mapeia uma chave á um mapa, por exemplo.
     * 
     * @param entrada
     *            entrada de mapa à ser escrita
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(java.util.Map.Entry entrada)
            throws IOException {
        if (entrada == null) {
            writer.write(NULL);
        } else {
            append(entrada.getKey());
            writer.write(KEY_MAPS_VALUE);
            append(entrada.getValue());
        }
        return this;
    }

    /**
     * Escreve uma mapa na saída associada. Ele escreve "[" em seguida cada
     * entrada do mapa, separados por ", " e por fim escreve "]". Trata cada
     * entrada do mapa com o método próprio para descrever entradas.
     * 
     * @param mapa
     *            mapa à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(java.util.Map mapa) throws IOException {
        if (mapa == null) {
            writer.write(NULL);
        } else {
            // final int size = mapa.size();
            writer.write(OPEN_LIST);
            java.util.Iterator entradas = mapa.entrySet().iterator();
            if (entradas.hasNext()) {
                append(entradas.next());
            }
            while (entradas.hasNext()) {
                writer.write(SEPARATOR);
                append(entradas.next());
            }
            writer.write(CLOSE_LIST);
        }
        return this;
    }

    /**
     * Escreve um objeto que seja <code>Appendable</code> na saída associada.
     * Pede para o objeto se escrever usando este <code>Appender</code>.
     * 
     * @param appendable
     *            appendable à ser escrito
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(Appendable appendable) throws IOException {
        if (appendable == null) {
            writer.write(NULL);
        } else {
            appendable.appendTo(this);
        }
        return this;
    }

    /**
     * Escreve um número na saída associada. Acrescenta quantos zeros à esquerda
     * forem necessários para que o <i>número</i> informado seja escrito com
     * <i>digitosNecessarios</i> dígitos. Caso <i>digitosNecessarios</i> seja
     * um número menor ou igual á zero, então o número não será escrito. Ignora
     * dígitos à esquerda além de <i>digitosNecessarios</i> se o número tiver
     * um número de dígitos maior que <i>digitosNecessarios</i>.
     * 
     * @param numero
     *            número à ser escrito
     * @param digitosNecessarios
     *            quantidade de dígitos necessários
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(int numero, int digitosNecessarios)
            throws IOException {
        if (digitosNecessarios > 0) {
            final int digitos = Utils.digits(numero);
            if (digitosNecessarios < digitos) {
                final int fator = (int) Math.pow(10, digitosNecessarios);
                numero %= fator;
            } else if (digitosNecessarios > digitos) {
                for (int i = digitosNecessarios - digitos; i > 0; i--) {
                    append(charForDigit[0]);
                }
            }
            append(numero);
        }
        return this;
    }

    /**
     * Escreve um número na saída associada. Acrescenta quantos zeros à esquerda
     * forem necessários para que o <i>número</i> informado seja escrito com
     * <i>digitosNecessarios</i> dígitos. Caso <i>digitosNecessarios</i> seja
     * um número menor ou igual á zero, então o número não será escrito. Ignora
     * dígitos à esquerda além de <i>digitosNecessarios</i> se o número tiver
     * um número de dígitos maior que <i>digitosNecessarios</i>.
     * 
     * @param numero
     *            número à ser escrito
     * @param digitosNecessarios
     *            quantidade de dígitos necessários
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(long numero, int digitosNecessarios)
            throws IOException {
        if (digitosNecessarios > 0) {
            final int digitos = Utils.digits(numero);
            if (digitosNecessarios < digitos) {
                final int fator = (int) Math.pow(10, digitosNecessarios);
                numero %= fator;
            } else if (digitosNecessarios > digitos) {
                for (int i = digitosNecessarios - digitos; i > 0; i--) {
                    append(charForDigit[0]);
                }
            }
            append(numero);
        }
        return this;
    }

    /**
     * Escreve um número armazenado numa <code>String</code> na saída
     * associada. Acrescenta quantos zeros à esquerda forem necessários para que
     * o <i>número</i> informado seja escrito com <i>digitosNecessarios</i>
     * dígitos. Caso <i>digitosNecessarios</i> seja um número menor ou igual á
     * zero, então o número não será escrito. Ignora dígitos à esquerda além de
     * <i>digitosNecessarios</i> se o número tiver um número de dígitos maior
     * que <i>digitosNecessarios</i>. Não valida se o conteúdo do número
     * passado é formado apenas por dígitos na base 10. Para isso deve-se
     * utilizar <code>Utils.apenasDigitos(numero)</code> antes.
     * 
     * @param numero
     *            número à ser escrito na forma de <code>String</code>
     * @param digitosNecessarios
     *            quantidade de dígitos necessários
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender appendNumber(String numero, int digitosNecessarios)
            throws IOException {
        if (digitosNecessarios > 0) {
            if (digitosNecessarios < numero.length()) {
                append(numero.substring(numero.length() - digitosNecessarios));
            } else if (digitosNecessarios > numero.length()) {
                for (int i = digitosNecessarios - numero.length(); i > 0; i--) {
                    append(charForDigit[0]);
                }
                append(numero);
            } else {
                append(numero);
            }
        }
        return this;
    }

    /**
     * Escreve um texto na saída associada. Acrescenta quantos espaços à direita
     * forem necessários para que o <i>texto</i> informado seja escrito com
     * <i>caracteresNecessarios</i> caracteres. Caso <i>caracteresNecessarios</i>
     * seja um número menor ou igual á zero, então o texto não será escrito.
     * Ignora caracteres à direita além de <i>caracteresNecessarios</i> se o
     * texto tiver mais caracteres que <i>caracteresNecessarios</i>.
     * 
     * @param texto
     *            texto à ser escrito
     * @param caracteresNecessarios
     *            quantidade de caracteres necessários
     * @return ele mesmo para permitir operações em cascata
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public final Appender append(String texto, int caracteresNecessarios)
            throws IOException {
        if (caracteresNecessarios > 0) {
            final int caracteres = texto.length();
            if (caracteresNecessarios < caracteres) {
                append(texto.substring(0, caracteresNecessarios));
            } else if (caracteresNecessarios > caracteres) {
                append(texto);
                for (int i = caracteresNecessarios - caracteres; i > 0; i--) {
                    append(SPACE);
                }
            } else {
                append(texto);
            }
        }
        return this;
    }

    /**
     * Escreve os dígitos fracionários de um <code>double</code>.
     * 
     * @param i
     *            dígitos á serem escritos
     * @param decimalOffset
     *            quantidade de decimais necessários
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    private final void appendFractDigits(long i, int decimalOffset)
            throws java.io.IOException {
        long mag = Utils.magnitude(i);
        long c;
        while (i > 0) {
            c = i / mag;
            writer.write(charForDigit[(int) c]);
            decimalOffset--;
            if (decimalOffset == 0) {
                writer.write('.');
            }
            c *= mag;
            if (c <= i) {
                i -= c;
            }
            mag = mag / 10;
        }
        if (i != 0) {
            writer.write(charForDigit[(int) i]);
        } else if (decimalOffset > 0) {
            writer.write(ZEROS[decimalOffset]);
            decimalOffset = 1;
        }
        decimalOffset--;
        if (decimalOffset == 0) {
            writer.write(DOT_ZERO);
        } else if (decimalOffset == -1) {
            writer.write('0');
        }
    }

    /**
     * Retorna a magnitude de um <code>float</code>.
     * 
     * @param numero
     *            número a ter sua magnitude calculada
     * @return a magnitude do número
     */
    private static int magnitude(float numero) {
        return magnitude(numero, Float.floatToIntBits(numero));
    }

    /**
     * Retorna a magnitude de um <code>float</code>.
     * 
     * @param numero
     *            número a ter sua magnitude calculada
     * @param floatToIntBits
     *            versão do <code>float</code> como <code>int</code>
     * @return a magnitude do número
     */
    private static int magnitude(float numero, int floatToIntBits) {
        int magnitude = (int) ((((floatToIntBits & floatExpMask) >> floatExpShift) - floatExpBias) * 0.301029995663981);
        if (magnitude < -44) {
            magnitude = -44;
        } else if (magnitude > 38) {
            magnitude = 38;
        }
        if (numero >= f_magnitudes[magnitude + 44]) {
            while (magnitude < 39 && numero >= f_magnitudes[magnitude + 44]) {
                magnitude++;
            }
            magnitude--;
            return magnitude;
        } else {
            while (magnitude > -45 && numero < f_magnitudes[magnitude + 44]) {
                magnitude--;
            }
            return magnitude;
        }
    }

    /**
     * Retorna a magnitude de um <code>double</code>.
     * 
     * @param numero
     *            número a ter sua magnitude calculada
     * @return a magnitude do número
     */
    private static int magnitude(double numero) {
        return magnitude(numero, Double.doubleToLongBits(numero));
    }

    /**
     * Retorna a magnitude de um <code>double</code>.
     * 
     * @param numero
     *            número a ter sua magnitude calculada
     * @param doubleToLongBits
     *            versão do <code>double</code> como <code>long</code>
     * @return a magnitude do número
     */
    private static int magnitude(double numero, long doubleToLongBits) {
        int magnitude = (int) ((((doubleToLongBits & doubleExpMask) >> doubleExpShift) - doubleExpBias) * 0.301029995663981);
        if (magnitude < -323) {
            magnitude = -323;
        } else if (magnitude > 308) {
            magnitude = 308;
        }
        if (numero >= d_magnitudes[magnitude + 323]) {
            while (magnitude < 309 && numero >= d_magnitudes[magnitude + 323]) {
                magnitude++;
            }
            magnitude--;
            return magnitude;
        } else {
            while (magnitude > -324 && numero < d_magnitudes[magnitude + 323]) {
                magnitude--;
            }
            return magnitude;
        }
    }

    /**
     * Saída de dados associada á este objeto.
     */
    private final java.io.Writer writer;
}
