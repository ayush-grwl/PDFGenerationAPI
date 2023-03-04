package com.pdfgeneration.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.pdfgeneration.entity.PDFData;

@Service
public class PDFService {
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	public Boolean generatePDF(PDFData pdfData) {
		
		Context data = setData(pdfData);
		String finalHtml=springTemplateEngine.process("PDFTemplate", data);
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmmss");  
	    Date date = new Date();  
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		try {
			PdfWriter pdfWriter=new PdfWriter(byteArrayOutputStream);
			DefaultFontProvider defaultFontProvider=new DefaultFontProvider(false, true, false);
			ConverterProperties converterProperties=new ConverterProperties();
			converterProperties.setFontProvider(defaultFontProvider);
			HtmlConverter.convertToPdf(finalHtml, pdfWriter, converterProperties);
			FileOutputStream fileOutputStream=new FileOutputStream(System.getProperty("user.home")+"/Downloads/"+formatter.format(date)+".pdf");
			byteArrayOutputStream.writeTo(fileOutputStream);
			byteArrayOutputStream.close();
			byteArrayOutputStream.flush();
			fileOutputStream.close();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Context setData(PDFData pdfData) {
		
		Context context=new Context();
		Map<String, Object> data=new HashMap<>();
		data.put("sellerData", "Seller:"+"<br>"+pdfData.getSeller()+"<br>"+pdfData.getSellerAddress()+"<br>"+"GSTIN: "+pdfData.getSellerGstin());
		data.put("buyerData", "Buyer:"+"<br>"+pdfData.getBuyer()+"<br>"+pdfData.getBuyerAddress()+"<br>"+"GSTIN: "+pdfData.getBuyerGstin());
		data.put("pdfData", pdfData);
		context.setVariables(data);
		return context;
		
	}
	
}
