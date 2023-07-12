package com.ShoppyReactive.utils;

import org.springframework.beans.BeanUtils;


import com.ShoppyReactive.dto.VendorDto;
import com.ShoppyReactive.entities.Vendor;

public class VendorUtils {

	public static VendorDto entityToDto(Vendor vendor)
	{
		VendorDto vendorDto = new VendorDto();
		BeanUtils.copyProperties(vendor, vendorDto);
		return vendorDto;
	}
	
	public static Vendor dtoToEntity(VendorDto vendorDto)
	{
		Vendor vendor = new Vendor();
		BeanUtils.copyProperties(vendorDto, vendor);
		return vendor;
	}
	
}
