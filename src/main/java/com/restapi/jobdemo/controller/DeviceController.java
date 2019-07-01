package com.restapi.jobdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.restapi.jobdemo.model.Location;
import com.restapi.jobdemo.model.RadioDevice;
import com.restapi.jobdemo.model.RadioDeviceModal;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@RestController
public class DeviceController {



    @RequestMapping(value = "/radios/{id}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveDevice(@RequestBody RadioDeviceModal input, @PathVariable("id") Long id) throws IOException {
        if (new File("./" + String.valueOf(id)).exists()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("");
        }
        Gson gson = new Gson();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(new RadioDevice(input.getAlias(), input.getAllowed_locations(), "undefined"));
        System.out.println(json);
        FileUtils.writeStringToFile(new File("./" + String.valueOf(id)), json);
        return ResponseEntity.status(HttpStatus.OK)
                .body("");
    }

    @RequestMapping(value = "/radios/{id}/location", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveAllowedLocation(@RequestBody Location input, @PathVariable("id") Long id) throws IOException {
        System.out.print(id);
        System.out.print(input.getLocation());
        if (! new File("./" + String.valueOf(id)).exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("");
        }
        Gson gson = new Gson();
        try (FileInputStream inputStream = new FileInputStream("./" + String.valueOf(id))) {
            String everything = IOUtils.toString(inputStream);
            RadioDevice rdDevice = gson.fromJson(everything, RadioDevice.class);

            for (String location : rdDevice.getAllowed_locations()) {
                if (location.toLowerCase().equals(input.getLocation().toLowerCase())) {
                    rdDevice.setCurrentLocation(input.getLocation());
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(rdDevice);
                    FileUtils.writeStringToFile(new File("./" + String.valueOf(id)), json);
                  //  gson.toJson(rdDevice, new FileWriter("./" + String.valueOf(id)));
                    return ResponseEntity.status(HttpStatus.OK)
                            .body("");
                }
            }
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("");
    }

    @RequestMapping(value = "/radios/{id}/location", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getLocation(@PathVariable("id") Long id) throws IOException {

        if (!new File("./" + String.valueOf(id)).exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("");
        }

        Gson gson = new Gson();
        try (FileInputStream inputStream = new FileInputStream("./" + String.valueOf(id))) {
            String everything = IOUtils.toString(inputStream);
            RadioDevice rdDevice = gson.fromJson(everything, RadioDevice.class);
            if (rdDevice.getCurrentLocation().equals("undefined")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{ \"location\": \"" +
                                rdDevice.getCurrentLocation() +
                                "\" }");
            } else {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("{ \"location\": \"" +
                                        rdDevice.getCurrentLocation() +
                                "\" }");
            }

        }
    }

}
