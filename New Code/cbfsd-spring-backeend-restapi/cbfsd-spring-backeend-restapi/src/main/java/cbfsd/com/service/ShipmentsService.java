package cbfsd.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbfsd.com.repository.ShipmentsRepository;

@Service
public class ShipmentsService {

	@Autowired
	ShipmentsRepository shipmentsRepository;
}
