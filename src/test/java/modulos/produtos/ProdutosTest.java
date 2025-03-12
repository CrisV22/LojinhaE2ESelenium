package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do modulo de Produtos")
    public class ProdutosTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        // ChromeDriver extende o WebDriver
        this.navegador = new ChromeDriver();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página de login
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Não é permitido registrar produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informaOUsuario("admin")
                .informaASenha("admin")
                .acessarListaDeProdutos()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("produtonome")
                .informarValorDoProduto("000")
                .informarCorDoProduto("Preto")
                .submeterFormularioDeAdicaoComErro()
                        .capturarMensagemApresentada();

        // Vou validar que a mensagem de erro foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Não é permitido registrar produto com valor maior que 7.000,00")
    public void testNaoEPermitidoRegistrarProdutoComValorMaiorQueSeteMil() {
        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informaOUsuario("admin")
                .informaASenha("admin")
                .acessarListaDeProdutos()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("produtonome")
                .informarValorDoProduto("7000.01")
                .informarCorDoProduto("Preto")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        // Vou validar que a mensagem de erro foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("É permitido registrar produto com valor no limite de 7.000,00")
    public void testEPermitidoRegistrarProdutoComValorNoLimiteDeSeteMil() {
        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informaOUsuario("admin")
                .informaASenha("admin")
                .acessarListaDeProdutos()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("produtonome")
                .informarValorDoProduto("7000.00")
                .informarCorDoProduto("Preto")
                .submeterFormularioDeAdicaoComSucesso()
                        .capturarMensagemApresentada();

        // Vou validar que a mensagem de erro foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("É permitido registrar produto com valor no limite de 0,01")
    public void testEPermitidoRegistrarProdutoComValorNoLimiteDeUmCentavo() {
        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informaOUsuario("admin")
                .informaASenha("admin")
                .acessarListaDeProdutos()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("produtonome")
                .informarValorDoProduto("001")
                .informarCorDoProduto("Preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        // Vou validar que a mensagem de erro foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @AfterEach
    public void afterEach() {
        // Vou fechar o navegador
        // navegador.quit();
    }
}
