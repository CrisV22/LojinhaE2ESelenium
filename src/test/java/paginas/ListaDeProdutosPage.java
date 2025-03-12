package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListaDeProdutosPage {
    private final WebDriver navegador;
    private final WebElement addProductButton;

    public ListaDeProdutosPage (WebDriver navegador) {
        this.navegador = navegador;
        this.addProductButton = navegador.findElement(By.cssSelector("a[class=\"waves-effect waves-light btn right\"]"));
    }

    public FormularioDeAdicaoDeProdutoPage acessarFormularioAdicaoNovoProduto() {
        addProductButton.click();
        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }

    public String capturarMensagemApresentada() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
