/**
 * @package com.tutv.controller.api
 * @date Dec 21, 2021
 * @author trinh
 */
package com.tutv.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutv.dto.HoSoXetTuyenDto;
import com.tutv.entity.HoSoXetTuyen;
import com.tutv.response.HoSoXetTuyenResponse;
import com.tutv.service.HoSoXetTuyenService;

/**
 * HoSoXetTuyenAPIController
 */
@Controller
@ResponseBody
public class HoSoXetTuyenAPIController {
	
	@Autowired
	private HoSoXetTuyenService hoSoXetTuyeService;
	
	@RequestMapping(value = "hoso", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String showHoSo() throws Exception {
		HoSoXetTuyenResponse user = hoSoXetTuyeService.getHoSo("idTaiKhoan");
		return user.toJson();
	}
	
	@RequestMapping(value = "hoso", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createHoSo(@RequestBody HoSoXetTuyenDto hoSoXetTuyenDto) throws Exception {
		
		HoSoXetTuyen kq = hoSoXetTuyeService.saveHoSo(hoSoXetTuyenDto);
		if (kq != null) {
			return "{\"kq\":\"ok\"}";
		}
		else {
			return "{\"kq\":\"error\"}";
		}
	}
	
	@RequestMapping(value = "hoso", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String updateHoSo(@RequestBody HoSoXetTuyenDto hoSoXetTuyenDto) throws Exception {
		
		HoSoXetTuyen kq = hoSoXetTuyeService.saveHoSo(hoSoXetTuyenDto);
		if (kq != null) {
			return "{\"kq\":\"ok\"}";
		}
		else {
			return "{\"kq\":\"error\"}";
		}
	}
}
