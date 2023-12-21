package com.service.master;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.model.master.MsProduct;
import com.service.master.impl.MsProductSvcImpl;

public class MsProductServiceTest {
	
	private MsProductSvcImpl msProductSvc;
	
	@Test
	public void testGetListSuccess() {
		List<MsProduct> list = msProductSvc.findAll(); 
		
//		assert
	}

}
