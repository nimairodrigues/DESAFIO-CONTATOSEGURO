package br.am.nimai.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.ListaUsuariosPage;
import br.am.nimai.page.NovoUsuarioPage;

public class NovoUsuarioTest extends BaseTest {
	
	ListaUsuariosPage listaUsuariosPage = new ListaUsuariosPage();
	NovoUsuarioPage novoUsuarioPage = new NovoUsuarioPage();
	
	@Before
	public void acessarTelaNovoUsuario() {
		listaUsuariosPage.clicarBotaoNovoUsuario();
	}
	
	@Test
	public void CT_01_cadastrarUmUsuario() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_02_cadastrarUmUsuarioSemPreencherNenhumCampo() {	
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_03_cadastrarUmUsuarioComEmailJaInseridoAoSistema() {
		//Preparando o ambiente
		novoUsuarioPage.criarUsuario("Nimai", "nimaipandita@outlook.com", "83123456789", "Manaus", 0, 15, 1997, "Empresa 1");
		listaUsuariosPage.clicarBotaoNovoUsuario();
		
		//Realizando o teste
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_04_cadastrarUmUsuarioComONomeContendoUmScriptJavaScript() {
		novoUsuarioPage.escreverCampoNome("<script>alert(\'XSS\')</script>");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
//		novoUsuarioPage.clicarBotaoSalvar();
		
//		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_05_cadastrarUmUsuarioComOEmailContendoUmScriptJavaScript() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("<script>alert(\'XSS\')</script>");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_06_cadastrarUmUsuarioComACidadeContendoUmScriptJavaScript() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("<script>alert(\'XSS\')</script>");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_07_cadastrarUmUsuarioComONomeContendoUmScriptSQL() {
		novoUsuarioPage.escreverCampoNome("\'\'; DROP TABLE usuarios; --");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_08_cadastrarUmUsuarioComOEmailContendoUmScriptSQL() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("\'\'; DROP TABLE usuarios; --");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_09_ccadastrarUmUsuarioComACidadeContendoUmScriptSQL() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("\'\'; DROP TABLE usuarios; --");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_10_cadastrarUmUsuarioSemNome() {
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_11_cadastrarUmUsuarioSemEmail() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_12_cadastrarUmUsuarioSemTelefone() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_13_cadastrarUmUsuarioSemCidade() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_14_cadastrarUmUsuarioSemData() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_15_cadastrarUmUsuarioSemEmpresa() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	//vai pedir pra clicar no ok e apresentar a mensagem
	}
	
	@Test
	public void CT_16_cadastrarUmUsuarioComONomeContendoOMinimoDeCaracteresPermitidos() {
		novoUsuarioPage.escreverCampoNome("Nimai"); //não sei o mínimo de caracteres permitido
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_17_cadastrarUmUsuarioComONomeContendoOMaximoDeCaracteresPermitidos() {
		novoUsuarioPage.escreverCampoNome("Nimai"); //não sei o máximo de caracteres permitido
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_18_cadastrarUmUsuarioComONomeContendo1CaractereAbaixoDoLimiteMinimo() {
		novoUsuarioPage.escreverCampoNome("Nimai"); //Abaixo de 1 é 0, mas não é possível criar com 0, o campo é obrigatório
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_19_cadastrarUmUsuarioComONomeContendo1CaractereAcimaDoLimiteMaximo() {
		novoUsuarioPage.escreverCampoNome("Nimai"); //Não sei a quantidade máxima
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_20_cadastrarUmUsuarioComEmailContendoMaximoDeCaracteresPermitidosNoNomeDeUsuario() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("usuarioComNomeExatoParaLimiteDe64Caracteres123456789012345678901234567890usuarioComNomeExatoParaLimiteDe64Caracteres123456789012345678901234567890"
				+ "@comODominioComNomeLongoOusadoQueUltrapassaAsExpectativasEAlcançaATotalidadeDos254CaracteresAssimQueAcabarr.comm");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_21_cadastrarUmUsuarioComEmailNaoContendoOArroba() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipanditaoutlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_22_cadastrarUmUsuarioComEmailContendoVirgulaNoLugarDoPonto() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook,com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_23_cadastrarUmUsuarioComEmailContendo2Arrobas() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_24_cadastrarUmUsuarioComEmailSemDominio() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_25_cadastrarUmUsuarioComEmailSemNomeDeUsuario() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_26_cadastrarUmUsuarioComEmailSemACategoriaDoDominio() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_27_cadastrarUmUsuarioComEmailContendoUmCaractereInvalidoEmNomeDeUsuario() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandit*a@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_28_cadastrarUmUsuarioComEmailContendoUmaCategoriaDoDominioMenorDoQueOAceitavel() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@a.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_29_cadastrarUmUsuarioComOEmailContendoApenasONomeDeUsuario() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_30_cadastrarUmUsuarioComDataContendoLetras() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverStringCampoData("a", "ab", "abcd");
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_31_cadastrarUmUsuarioComNomeContendoApenas1Simbolo() {
		novoUsuarioPage.escreverCampoNome("*");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_32_cadastrarUmUsuarioComEmailContendoApenas1Simbolo() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("*");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_33_cadastrarUmUsuarioComTelefoneContendoApenas1Simbolo() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("*");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_34_cadastrarUmUsuarioComACidadeContendoApenas1Simbolo() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("*");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_35_cadastrarUmUsuarioComADataContendoApenas1Simbolo() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverStringCampoData("*", "", "");
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_36_cadastrarUmUsuarioComADataContendoApenasODia() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(01, 00, 0000);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_37_cadastrarUmUsuarioComADataContendoApenasOMes() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(00, 02, 0000);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_38_cadastrarUmUsuarioComADataContendoApenasOAno() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(00, 00, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_39_cadastrarUsuarioComCaracteresJaponeses() {
		novoUsuarioPage.escreverCampoNome("山田 太郎");
		novoUsuarioPage.escreverCampoEmail("robertosilva@yahoo.co.jp");
		novoUsuarioPage.escreverCampoTelefone("+81 3 1234 5678");
		novoUsuarioPage.escreverCampoCidade("東京");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_40_cadastrarUsuariosComCaracteresRussos() {
		novoUsuarioPage.escreverCampoNome("Иван Иванович Иванов");
		novoUsuarioPage.escreverCampoEmail("ivanivanovich@yandex.ru");
		novoUsuarioPage.escreverCampoTelefone("'+7 495 123 4567");
		novoUsuarioPage.escreverCampoCidade("Москва");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_41_cadastrarUmUsuarioComOTelefoneContendoOMinimoDeNumerosPermitidos() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789"); //não sei o mínimo
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_42_cadastrarUmUsuarioComOTelefoneContendoOLimiteMaximoDeNumerosPermitidos() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789"); //não sei o máximo
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_43_cadastrarUmUsuarioComOTelefoneContendo1CaractereAcimaDoLimiteMaximo() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789"); //não sei o mínimo
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_44_cadastrarUmUsuarioComOTelefoneContendo1CaractereAbaixoDoLimiteMinimo() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123456789"); //não sei o máximo
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_45_cadastrarUmUsuarioComTelefoneContendoUmaLetraEntreOsNumeros() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("83123a56789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}
	
	@Test
	public void CT_46_cadastrarUmUsuarioComTelefoneContendoUmSimboloEntreOsNumeros() {
		novoUsuarioPage.escreverCampoNome("Nimai");
		novoUsuarioPage.escreverCampoEmail("nimaipandita@outlook.com");
		novoUsuarioPage.escreverCampoTelefone("831234*6789");
		novoUsuarioPage.escreverCampoCidade("Manaus");
		novoUsuarioPage.escreverCampoData(0, 15, 1997);
		novoUsuarioPage.selecionarEmpresa("Empresa 1");
		
		novoUsuarioPage.clicarBotaoSalvar();
		
		Assert.assertTrue(false);	
	}

}
