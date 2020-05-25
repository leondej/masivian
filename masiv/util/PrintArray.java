package com.masiv.util;

public class PrintArray {

    private int rowPerPage;
    private int columnPerPage;
    //constructor donde se especifica la cantidad de filas y columnas por pagina
    public PrintArray(int rowPerPage, int columnPerPage){
        this.rowPerPage=rowPerPage;
        this.columnPerPage=columnPerPage;

    }
//metodo que imprime el arreglo
    public void printData(int[] p) {
        int pageNumber = 1;
        int elementByPage = 1;
        int fullElement = p.length -1;
        while (elementByPage <= fullElement) {
            printHeadPage(pageNumber, fullElement);
            printPage(p, rowPerPage,columnPerPage, elementByPage);
            pageNumber++;
            elementByPage += rowPerPage*columnPerPage;
        }
    }
    //imprime la descripcion inicial de la pagina con su respectivo numero de pagina 
    private void printHeadPage(int pageNumber, int fullElement) {
        System.out.print(" new version The First ");
        System.out.print(Integer.toString(fullElement));
        System.out.print(" Prime Numbers === Page ");
        System.out.print(Integer.toString(pageNumber));
        System.out.println("\n");
    }
//imprime la pagina
    private void printPage(int[] p, int rowPerPage, int columnPerPage, int elementByPage) {

        for (int elements=elementByPage; elements <= elementByPage+rowPerPage-1;
             elements++) {
            printElements(p, columnPerPage,rowPerPage, elements);
        }
        System.out.println("\f");

    }
    //imprime los elementos de la pagina
    private void printElements(int[] p, int columnPage, int rowPerPage, int elements) {
        for (int column = 0; column <= columnPage -1; column++)
            if (elements + column * rowPerPage <= p.length-1)
                System.out.printf("%10d", p[elements + column * rowPerPage]);
        System.out.println();
    }





}
