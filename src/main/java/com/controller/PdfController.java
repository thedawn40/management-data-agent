package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.common.PdfView;
import com.dao.TxSellHdrDao;
import com.dao.master.MsUserDao;
import com.service.TxSellHdrService;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Controller
public class PdfController {
	
	@Autowired
	MsUserDao msUserDao;
	
	@Autowired
	TxSellHdrService txSellHdrService;

	@Autowired
	TxSellHdrDao txSellHdrDao;

    private final TemplateEngine templateEngine;

    public PdfController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping("/generate-pdf")
    public ModelAndView generatePdf() throws Exception {
        Context context = new Context();
        
        double revenue = 0;
        if(txSellHdrService.findAll().size()>0) {
        	for(int i = 0 ; i < txSellHdrService.findAll().size(); i++) {
        		double totalPrice = Double.parseDouble(txSellHdrService.findAll().get(i).getTotalPrice().toString());
        		revenue = revenue + totalPrice;
        	}
        }
        
        context.setVariable("totalUser", msUserDao.findAll().size());
        context.setVariable("revenue", revenue);

        String htmlContent = templateEngine.process("pdf-template", context);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        // Set response content type to PDF
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new PdfView(outputStream.toByteArray()));
        return modelAndView;
    }
    
    @GetMapping("/generate-pdf-content")
    @ResponseBody
    public String generatePdfContent() {
        Context context = new Context();
        // Add any model attributes or variables needed for the template

        return templateEngine.process("pdf-template", context);
    }
}
