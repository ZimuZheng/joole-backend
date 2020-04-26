package com.itlize.service;

import com.itlize.entity.Manufacturer;

public interface ManufacturerService {

    // C
    void addNewManufacturer(Manufacturer manufacturer) throws Exception;

    // R
    Manufacturer getManufacturerById(Long mid) throws Exception;

    // U
    void updateManufacturer(Manufacturer manufacturer);

    // D
    void deleteManufacturer(Manufacturer manufacturer);
}
