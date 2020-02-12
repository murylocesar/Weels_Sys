/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo
 */
public class Imprimir {

    cadastro obj_config = new cadastro();
    ConectaBanco controle = new ConectaBanco();
    ConectaBanco Veiculo = new ConectaBanco();

    java.util.Date DataSistema = new java.util.Date();//Data atual
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//Formato Brasileiro

    NumberFormat nf = NumberFormat.getCurrencyInstance();// transforma em valor 'R$...'

    ///configuração do PDF
    File URL_pdf = new File("Movimentação.pdf");//URL do pdf

    Font padrão = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);// fonte padrão

    com.itextpdf.text.Document doc = new com.itextpdf.text.Document(PageSize.A4, 72, 72, 50, 72);//cria o documento tamanho A4, margens de 2,54cm
    OutputStream os = null;

    String veiculo = null, condição = null, garantia, ar_con, direção_hid, flex;
    double espaçamento = 10;

    Paragraph separador;

    public Imprimir() throws FileNotFoundException, DocumentException {
        obj_config.carregaconfig();
        controle.Conexao(obj_config._url);
        Veiculo.Conexao(obj_config._url);

        os = new FileOutputStream(URL_pdf); //cria a stream de saída

//        doc = new Document(PageSize.A4);//cria o documento tamanho A4, margens de 2,54cm

        PdfWriter.getInstance(doc, os);//associa a stream de saída ao

        doc.open();//abre o documento

        separador = new Paragraph("____________________________________________________________", new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD));//adiciona o texto ao PDF
        separador.setSpacingAfter((float) espaçamento);
        separador.setSpacingBefore((float) espaçamento - 25);
    }

    public void veiculos_outros(boolean x) throws SQLException {

        if (Veiculo.rs.getString("veiculo").equals("M")) {
            veiculo = "MOTO";
        } else if (Veiculo.rs.getString("veiculo").equals("A")) {
            veiculo = "AUTOMOVEL";
        } else if (Veiculo.rs.getString("veiculo").equals("O")) {
            veiculo = "MICRO/ÔNIBUS";
        } else if (Veiculo.rs.getString("veiculo").equals("C")) {
            veiculo = "CAMINHÃO";
        }

        if (Veiculo.rs.getString("condicao").equals("N")) {
            condição = "NOVO(A)";
        } else if (Veiculo.rs.getString("condicao").equals("S")) {
            condição = "SEMI";
        } else if (Veiculo.rs.getString("condicao").equals("U")) {
            condição = "USADO(A)";
        }
        if (x) {
            if (controle.rs.getString("tipo_garantia").equals("MES")) {
                garantia = "MÊS";
            } else {
                garantia = controle.rs.getString("tipo_garantia");
            }
        }
        if (Veiculo.rs.getString("AR_CONDICIONADO").equals("T")) {
            ar_con = "X";
        } else {
            ar_con = " ";
        }

        if (Veiculo.rs.getString("DIRECAO_HIDRAULICA").equals("T")) {
            direção_hid = "X";
        } else {
            direção_hid = " ";
        }

        if (Veiculo.rs.getString("flex").equals("T")) {
            flex = "X";
        } else {
            flex = " ";
        }

    }

    public String buscaFuncionarios(int id_funcionario) {
        ConectaBanco fun = new ConectaBanco();
        fun.Conexao(obj_config._url);
        fun.executaSQL("select nome from tb_funcionarios where id_funcionario = '" + id_funcionario + "'");
        String nome = null;
        try {
            fun.rs.first();
            nome = fun.rs.getString("nome");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nome não encontrado" + ex);
        }
        fun.Desconecta();
        return nome;

    }

    public void Comprar_PDF(int id_comprar) throws DocumentException, BadElementException, FileNotFoundException, IOException, SQLException, Exception {
        controle.executaSQL("select * from tb_compras C,tb_clientes_fornecedores F where C.id_compra = '" + id_comprar + "' and C.id_fornecedor=F.id_cliente_fornecedor");
        controle.rs.first();

        Veiculo.executaSQL("select * from tb_veiculos V ,tb_modelos M where V.id_veiculo = '" + controle.rs.getInt("id_veiculo") + "' and V.modelo=M.id_modelo");
        Veiculo.rs.first();

        veiculos_outros(false);

        try {
            Image LogoMarca = Image.getInstance("D:\\Pronatec-2015.png");
            LogoMarca.setAlignment(Element.ALIGN_CENTER);

            Paragraph Titulo = new Paragraph("DADOS DA COMPRA", new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD));//adiciona o texto ao PDF
            Titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph Data = new Paragraph("DATA DA COMPRAR: " + formato.format(controle.rs.getDate("datacad"))
                    + "                             DATA DA EMISÃO: " + formato.format(DataSistema), padrão);//adiciona o texto ao PDF
            Data.setSpacingAfter((float) espaçamento);

            Paragraph Vendedor = new Paragraph("VENDEDOR (A): " + buscaFuncionarios(controle.rs.getInt("id_funcionario")), padrão);//adiciona o texto ao PDF
            Vendedor.setAlignment(Element.ALIGN_JUSTIFIED);
            Vendedor.setSpacingAfter((float) espaçamento);

            Paragraph Cliente = new Paragraph("FORNECEDOR(A): " + controle.rs.getString("nome"), padrão);//adiciona o texto ao PDF
            Cliente.setAlignment(Element.ALIGN_JUSTIFIED);
            Cliente.setSpacingAfter((float) espaçamento);

            Paragraph Cpf_cnpj = new Paragraph("CPF_CNPJ: " + controle.rs.getString("cpf_cnpj"), padrão);//adiciona o texto ao PDF
            Cpf_cnpj.setAlignment(Element.ALIGN_JUSTIFIED);
            Cpf_cnpj.setSpacingAfter((float) espaçamento);

            Paragraph Garantia_valor = new Paragraph("VALOR: " + nf.format(new BigDecimal(controle.rs.getString("valor"))), padrão);//adiciona o texto ao PDF
            Garantia_valor.setAlignment(Element.ALIGN_JUSTIFIED);
            Garantia_valor.setSpacingAfter((float) espaçamento + 10);

            Paragraph Subtitulo = new Paragraph("DADOS DO VEICULO", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));//adiciona o texto ao PDF
            Subtitulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph Veiculo_condição_marca = new Paragraph("VEICULO: " + veiculo + "        CONDIÇÃO: " + condição + "        MARCA: " + Veiculo.rs.getString("MARCA"), padrão);//adiciona o texto ao PDF
            Veiculo_condição_marca.setAlignment(Element.ALIGN_JUSTIFIED);
            Veiculo_condição_marca.setSpacingAfter((float) espaçamento);

            Paragraph Modelo = new Paragraph("MODELO: " + Veiculo.rs.getString("descricao"), padrão);//adiciona o texto ao PDF
            Modelo.setAlignment(Element.ALIGN_JUSTIFIED);
            Modelo.setSpacingAfter((float) espaçamento);

            Paragraph Versão = new Paragraph("VERSÃO: " + Veiculo.rs.getString("VERSAO"), padrão);//adiciona o texto ao PDF
            Versão.setAlignment(Element.ALIGN_JUSTIFIED);
            Versão.setSpacingAfter((float) espaçamento);

            Paragraph DATAFAB_Placa_Chassi = new Paragraph("DATA FABRICAÇÃO: " + formato.format(Veiculo.rs.getDate("dataFAB")) + "   PLACA: " + Veiculo.rs.getString("PLACA")
                    + "   CHASSI: " + Veiculo.rs.getString("CHASSI"), padrão);//adiciona o texto ao PDF
            DATAFAB_Placa_Chassi.setAlignment(Element.ALIGN_JUSTIFIED);
            DATAFAB_Placa_Chassi.setSpacingAfter((float) espaçamento);

            Paragraph adicionais = new Paragraph("AR CONDICIONADO (" + ar_con + ")                            DIREÇÃO HIDRALICA (" + direção_hid + ")                      FLEX (" + flex + ")", padrão);//adiciona o texto ao PDF
            adicionais.setAlignment(Element.ALIGN_JUSTIFIED);
            adicionais.setSpacingAfter((float) espaçamento);

            Paragraph obs = new Paragraph("OBS: " + Veiculo.rs.getString("OBS"), padrão);//adiciona o texto ao PDF
            obs.setSpacingAfter((float) espaçamento);

            Paragraph ASSINATURA = new Paragraph("ASSINATURA:_____________________________________________________________", padrão);//adiciona o texto ao PDF
            ASSINATURA.setAlignment(Element.ALIGN_JUSTIFIED);

            doc.addAuthor("Murylo César De Souza");//Autor
            doc.add(LogoMarca);
            doc.add(Titulo);
            doc.add(separador);
            doc.add(Data);
            doc.add(Vendedor);
            doc.add(Cliente);
            doc.add(Cpf_cnpj);
            doc.add(Garantia_valor);
            doc.add(Subtitulo);
            doc.add(separador);
            doc.add(Veiculo_condição_marca);
            doc.add(Modelo);
            doc.add(Versão);
            doc.add(DATAFAB_Placa_Chassi);
            doc.add(adicionais);
            doc.add(obs);
            doc.add(ASSINATURA);
        } finally {

            controle.Desconecta();
            Veiculo.Desconecta();
            if (doc != null) {
                doc.close();//fechamento do documento
            }
            if (os != null) {
                os.close();  //fechamento da stream de saída
            }
            Desktop.getDesktop().open(URL_pdf);
        }
    }

    public void Venda_PDF(int id_venda) throws DocumentException, BadElementException, FileNotFoundException, IOException, SQLException, Exception {
        controle.executaSQL("select * from tb_vendas V ,tb_clientes_fornecedores C where V.id_venda = '" + id_venda + "' and V.id_cliente=C.id_cliente_fornecedor");

        controle.rs.first();

        Veiculo.executaSQL("select * from tb_veiculos V ,tb_modelos M where V.id_veiculo = '" + controle.rs.getInt("id_veiculo") + "' and V.modelo=M.id_modelo");
        Veiculo.rs.first();

        veiculos_outros(true);

        try {

            Image LogoMarca = Image.getInstance("Imagens\\Pronatec.png");
            LogoMarca.setAlignment(Element.ALIGN_CENTER);

            Paragraph Titulo = new Paragraph("DADOS DA VENDA", new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD));//adiciona o texto ao PDF
            Titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph Data = new Paragraph("DATA DA VENDA: " + formato.format(controle.rs.getDate("datacad"))
                    + "                             DATA DA EMISÃO: " + formato.format(DataSistema), padrão);//adiciona o texto ao PDF
            Data.setSpacingAfter((float) espaçamento);

            Paragraph Vendedor = new Paragraph("VENDEDOR (A): " + buscaFuncionarios(controle.rs.getInt("id_funcionario")), padrão);//adiciona o texto ao PDF
            Vendedor.setAlignment(Element.ALIGN_JUSTIFIED);
            Vendedor.setSpacingAfter((float) espaçamento);

            Paragraph Cliente = new Paragraph("CLIENTE: " + controle.rs.getString("nome"), padrão);//adiciona o texto ao PDF
            Cliente.setAlignment(Element.ALIGN_JUSTIFIED);
            Cliente.setSpacingAfter((float) espaçamento);

            Paragraph Cpf_cnpj = new Paragraph("CPF_CNPJ: " + controle.rs.getString("cpf_cnpj"), padrão);//adiciona o texto ao PDF
            Cpf_cnpj.setAlignment(Element.ALIGN_JUSTIFIED);
            Cpf_cnpj.setSpacingAfter((float) espaçamento);

            String data = null;
            Validacoes validar = new Validacoes();
            if (null != garantia) switch (garantia) {
                case "DIA":
                    data = validar.incrementarData(formato.format(controle.rs.getDate("datacad")), controle.rs.getInt("TEMPO_GARANTIA"), 0, 0);
                    break;
                case "MÊS":
                    data = validar.incrementarData(formato.format(controle.rs.getDate("datacad")), 0, controle.rs.getInt("TEMPO_GARANTIA"), 0);
                    break;
                default:
                    data = validar.incrementarData(formato.format(controle.rs.getDate("datacad")), 0, 0, controle.rs.getInt("TEMPO_GARANTIA"));
                    break;
            }

            Paragraph Garantia_valor = new Paragraph("GARANTIA: " + controle.rs.getString("TEMPO_GARANTIA") + " " + garantia
                    + "                                          VENCIMENTO DA GARANTIA: " + data, padrão);//adiciona o texto ao PDF
            Garantia_valor.setAlignment(Element.ALIGN_JUSTIFIED);
            Garantia_valor.setSpacingAfter((float) espaçamento + 10);

            Paragraph valor = new Paragraph("VALOR: " + nf.format(new BigDecimal(controle.rs.getString("valor_total"))), padrão);//adiciona o texto ao PDF
            valor.setAlignment(Element.ALIGN_JUSTIFIED);
            valor.setSpacingAfter((float) espaçamento + 10);

            Paragraph Subtitulo = new Paragraph("DADOS DO VEICULO", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));//adiciona o texto ao PDF
            Subtitulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph Veiculo_condição_marca = new Paragraph("VEICULO: " + veiculo + "        CONDIÇÃO: " + condição + "        MARCA: " + Veiculo.rs.getString("MARCA"), padrão);//adiciona o texto ao PDF
            Veiculo_condição_marca.setAlignment(Element.ALIGN_JUSTIFIED);
            Veiculo_condição_marca.setSpacingAfter((float) espaçamento);

            Paragraph Modelo = new Paragraph("MODELO: " + Veiculo.rs.getString("descricao"), padrão);//adiciona o texto ao PDF
            Modelo.setAlignment(Element.ALIGN_JUSTIFIED);
            Modelo.setSpacingAfter((float) espaçamento);

            Paragraph Versão = new Paragraph("VERSÃO: " + Veiculo.rs.getString("VERSAO"), padrão);//adiciona o texto ao PDF
            Versão.setAlignment(Element.ALIGN_JUSTIFIED);
            Versão.setSpacingAfter((float) espaçamento);

            Paragraph DATAFAB_Placa_Chassi = new Paragraph("DATA FABRICAÇÃO: " + formato.format(Veiculo.rs.getDate("dataFAB")) + "   PLACA: " + Veiculo.rs.getString("PLACA")
                    + "   CHASSI: " + Veiculo.rs.getString("CHASSI"), padrão);//adiciona o texto ao PDF
            DATAFAB_Placa_Chassi.setAlignment(Element.ALIGN_JUSTIFIED);
            DATAFAB_Placa_Chassi.setSpacingAfter((float) espaçamento);

            Paragraph adicionais = new Paragraph("AR CONDICIONADO (" + ar_con + ")                            DIREÇÃO HIDRALICA (" + direção_hid + ")                      FLEX (" + flex + ")", padrão);//adiciona o texto ao PDF
            adicionais.setAlignment(Element.ALIGN_JUSTIFIED);
            adicionais.setSpacingAfter((float) espaçamento);

            Paragraph obs = new Paragraph("OBS: " + Veiculo.rs.getString("OBS"), padrão);//adiciona o texto ao PDF
            obs.setSpacingAfter((float) espaçamento);

            Paragraph ASSINATURA = new Paragraph("ASSINATURA:_____________________________________________________________", padrão);//adiciona o texto ao PDF
            ASSINATURA.setAlignment(Element.ALIGN_JUSTIFIED);

            doc.addAuthor("Murylo César De Souza");//Autor
            doc.add(LogoMarca);
            doc.add(Titulo);
            doc.add(separador);
            doc.add(Data);
            doc.add(Vendedor);
            doc.add(Cliente);
            doc.add(Cpf_cnpj);
            doc.add(Garantia_valor);
            doc.add(valor);
            doc.add(Subtitulo);
            doc.add(separador);
            doc.add(Veiculo_condição_marca);
            doc.add(Modelo);
            doc.add(Versão);
            doc.add(DATAFAB_Placa_Chassi);
            doc.add(adicionais);
            doc.add(obs);
            doc.add(ASSINATURA);
        } finally {

            controle.Desconecta();
            Veiculo.Desconecta();
            if (doc != null) {
                doc.close();//fechamento do documento
            }
            if (os != null) {
                os.close();  //fechamento da stream de saída
            }
            Desktop.getDesktop().open(URL_pdf);
        }
    }

}
