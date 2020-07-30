package com.perenco.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.perenco.dto.ProyectosDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerarProyectoPdfReport {

    private static final int NUMERO_COLUMNAS = 8;

    public ByteArrayInputStream proyectoReport(final ProyectosDTO proyectoDTO) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            PdfPTable table = new PdfPTable(NUMERO_COLUMNAS);
            table.setWidthPercentage(100.0f);
            table.setSpacingBefore(10);

            // define font for table header row
            Font font = FontFactory.getFont(FontFactory.TIMES);
            font.setColor(BaseColor.WHITE);

            // define table header cell
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(5);

            // write table header
            cell.setPhrase(new Phrase("Id", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Nombre", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("descripcion", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Fecha Inicio", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Fecha Estimada Fin", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Fecha Real", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Nombre Pozo", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Nombre Sistema", font));
            table.addCell(cell);


            table.addCell(proyectoDTO.getId());
            table.addCell(proyectoDTO.getNombre());
            table.addCell(proyectoDTO.getDescripcion());
            table.addCell(proyectoDTO.getFechaInicial());
            table.addCell(proyectoDTO.getFechaEstimadaFin());
            table.addCell(proyectoDTO.getFechaRealEntrega());
            table.addCell(proyectoDTO.getPozo());
            table.addCell(proyectoDTO.getSistemas());


            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);




        } catch (Exception e) {
            log.info(" Error generando pdf : {} ", e.getMessage());
        } finally {
            document.close();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
