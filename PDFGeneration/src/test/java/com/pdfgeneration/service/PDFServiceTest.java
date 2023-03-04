package com.pdfgeneration.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pdfgeneration.entity.Items;
import com.pdfgeneration.entity.PDFData;

@SpringBootTest
class PDFServiceTest {

	@Autowired
	private PDFService pdfService;
	
	@Test
	void generatePDF() {
		
		PDFData pdfData=new PDFData("XYZ Pvt. Ltd.","29AABBCCDD121ZD","New Delhi, India","Vedant Computers","29AABBCCDD131ZD","New Delhi, India",List.of(new Items("Product 1","12 Nos",123.00,1476.00)));
		Boolean generatePDF = pdfService.generatePDF(pdfData);
		assertThat(generatePDF).isTrue();
		
	}
	
	

}
