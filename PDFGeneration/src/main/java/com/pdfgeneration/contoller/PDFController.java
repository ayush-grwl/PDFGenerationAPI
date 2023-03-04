package com.pdfgeneration.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pdfgeneration.entity.PDFData;
import com.pdfgeneration.service.PDFService;

import jakarta.validation.Valid;

@RestController
public class PDFController {
	
	@Autowired
	private PDFService pdfService;
	
	@GetMapping("/generatePDF")
	public ResponseEntity<String> generatePDF(@Valid @RequestBody PDFData pdfData, BindingResult bindingResult) {
		
		String errors="";
		try {
			if(bindingResult.hasErrors()) {
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				for(ObjectError error:allErrors) {
					errors=errors+error.getDefaultMessage()+"\n";
				}
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors.substring(0,errors.length()-1)); 
			}
		}catch (Exception e) {
			
		}
		Boolean result = pdfService.generatePDF(pdfData);
		if(result)
			return ResponseEntity.ok("PDF Downloaded Succesfully");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!! Please Try Again Later");
	}
	
}
