import java.io.File;

import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.write.*;
import jxl.write.Number;

import jxl.read.biff.BiffException;
import java.io.IOException;

public class LerEscreverExcel {

    private String as1;
    private String as2;
    private String as3;
    private String as4;
    private String as5;
    private String enderecoExcel = "H:\\FPOO\saída.xls";

    public LerEscreverExcel(String excel){
        this.enderecoExcel = excel;
    }

    public void lerExcel() throws IOException, BiffException {

        Workbook workbook = Workbook.getWorkbook(new File(enderecoExcel));

        Sheet sheet = workbook.getSheet(0);

        int linhas = sheet.getRows();

        System.out.println("Iniciando a leitura da planilha XLS:");

        for (int i = 0; i < linhas; i++) {

            Cell a1 = sheet.getCell(0, i);

            Cell a2 = sheet.getCell(1, i);

            Cell a3 = sheet.getCell(2, i);

            Cell a4 = sheet.getCell(3, i);

            Cell a5 = sheet.getCell(4, i);

            String as1 = a1.getContents();

            String as2 = a2.getContents();

            String as3 = a3.getContents();

            String as4 = a4.getContents();

            String as5 = a5.getContents();

            System.out.println("Coluna 1: " + as1);

            System.out.println("Coluna 2: " + as2);

            System.out.println("Coluna 3: " + as3);

            System.out.println("Coluna 4: " + as4);

            System.out.println("Coluna 5: " + as5);

            System.out.println("\n");

        }

        workbook.close();

    }



    public void escreverExcel() {

            //1. Create an Excel file
            WritableWorkbook arquivoExcel = null;
            try {

                arquivoExcel = Workbook.createWorkbook(new File(enderecoExcel));

                // create an Excel sheet
                WritableSheet planilha = arquivoExcel.createSheet("Nova Planilha", 0);

                // add something into the Excel sheet
                Label label = new Label(5, 0, "Coluna1");
                planilha.addCell(label);

                Number number = new Number(5, 1, 1);
                planilha.addCell(number);

                number = new Number(5, 2, 2);
                planilha.addCell(number);

                label = new Label(6, 0, "Coluna2");
                planilha.addCell(label);

                label = new Label(6, 1, "Texto1");
                planilha.addCell(label);

                label = new Label(6, 2, "Texto2");
                planilha.addCell(label);

                arquivoExcel.write();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            } finally {

                if (arquivoExcel != null) {
                    try {
                        arquivoExcel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }


            }

        }

    }
