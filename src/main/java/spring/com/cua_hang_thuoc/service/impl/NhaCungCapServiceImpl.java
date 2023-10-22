package spring.com.cua_hang_thuoc.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.com.cua_hang_thuoc.dto.NhaCungCapDto;
import spring.com.cua_hang_thuoc.entity.NhaCungCap;
import spring.com.cua_hang_thuoc.repo.NhaCungCapRepo;
import spring.com.cua_hang_thuoc.service.NhaCungCapService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    @Autowired
    NhaCungCapRepo nhaCungCapRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<NhaCungCapDto> findAllDto() {
        return nhaCungCapRepo.findByTrangThaiTrue().stream()
                .map(i -> modelMapper.map(i, NhaCungCapDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NhaCungCap> findById(String id) {
        return nhaCungCapRepo.findById(id);
    }

    @Override
    public NhaCungCapDto save(NhaCungCapDto nhaCungCapDto) {
        NhaCungCap nhaCungCap = getNhaCungCap(nhaCungCapDto);
        return getNhaCungCapDto(nhaCungCapRepo.save(nhaCungCap));
    }

    @Override
    public String delete(String id) {
        return String.valueOf(nhaCungCapRepo.setTrangThaiFalse(id));
    }

    @Override
    public NhaCungCapDto update(NhaCungCapDto nhaCungCapDto) {
        NhaCungCap nhaCungCap = getNhaCungCap(nhaCungCapDto);
        if (nhaCungCap.getMaNhaCungCap() != null) {
            return getNhaCungCapDto(nhaCungCapRepo.save(nhaCungCap));
        }
        throw new NullPointerException();
    }

    @Override
    public NhaCungCapDto getNhaCungCapDto(NhaCungCap nhaCungCap) {
        return modelMapper.map(nhaCungCap, NhaCungCapDto.class);
    }

    @Override
    public NhaCungCap getNhaCungCap(NhaCungCapDto nhaCungCapDto) {
        return modelMapper.map(nhaCungCapDto, NhaCungCap.class);
    }
}
