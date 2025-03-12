package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormularioDeAdicaoDeProdutoPage {
    private final WebDriver navegador;
    private final WebElement productField;
    private final WebElement valueField;
    private final WebElement colorsField;
    private final WebElement saveButton;

    public FormularioDeAdicaoDeProdutoPage (WebDriver navegador) {
        this.navegador = navegador;
        this.productField = navegador.findElement(By.id("produtonome"));
        this.valueField = navegador.findElement(By.id("produtovalor"));
        this.colorsField = navegador.findElement(By.id("produtocores"));
        this.saveButton = navegador.findElement(By.id("btn-salvar"));
    }

    public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto(String produtoNome) {
        productField.sendKeys(produtoNome);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarValorDoProduto(String produtoValor) {
        valueField.sendKeys(produtoValor);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarCorDoProduto(String produtoCor) {
        colorsField.sendKeys(produtoCor);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro() {
        saveButton.click();
        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeAdicaoDeProdutoPage submeterFormularioDeAdicaoComSucesso() {
        WebElement saveButton = navegador.findElement(By.id("btn-salvar"));
        saveButton.click();
        return this;
    }

    public String capturarMensagemApresentada() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
