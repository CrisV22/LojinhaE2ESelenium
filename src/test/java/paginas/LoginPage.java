package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver navegador;
    private final WebElement usernameField;
    private final WebElement passwordField;
    private final WebElement loginButton;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
        this.usernameField = navegador.findElement(By.id("usuario"));
        this.passwordField = navegador.findElement(By.id("senha"));
        this.loginButton = navegador.findElement(By.id("btn-entrar"));
    }

    public LoginPage informaOUsuario(String usuario) {
        usernameField.sendKeys("admin");
        return this;
    }

    public LoginPage informaASenha(String senha) {
        passwordField.sendKeys("admin");
        return this;
    }

    public ListaDeProdutosPage acessarListaDeProdutos() {
        loginButton.click();
        return new ListaDeProdutosPage(navegador);
    }
}
