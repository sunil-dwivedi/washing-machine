package com.cts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.domain.WashingMachine;
import com.cts.program.Program;
import com.cts.service.WashingMachineService;
import com.cts.service.impl.InitializeService;
import com.cts.service.impl.ProgramExecutorService;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private final ProgramExecutorService programExecutorService;
    private final WashingMachineService washingMachineService;
    private final InitializeService initializeService;

    private WashingMachine washingMachine;

    @Autowired
    public Controller(ProgramExecutorService programExecutorService, WashingMachineService washingMachineService, InitializeService initializeService) {
        this.programExecutorService = programExecutorService;
        this.washingMachineService = washingMachineService;
        this.initializeService = initializeService;
        this.washingMachine = initializeService.getWashingMachine();
    }



    @RequestMapping(value = "/state", method = RequestMethod.GET)
    public String getState() {
        LOGGER.info("State request");
        return programExecutorService.getStatus();
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() throws InterruptedException {
        try {
            programExecutorService.startProgram();
        } catch (NullPointerException e) {
            return "Set up program first";
        }
        return "Started";
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public String stop() {
        programExecutorService.stopProgram();
        return "Stopped";
    }

    @RequestMapping(value = "/program/(index)", method = RequestMethod.GET)
    public String selectProgramme(@RequestParam Integer index) {

        try {
            List<Program> programs = washingMachine.getPrograms();
            programExecutorService.setProgram(programs.get(index));

        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("No such program");
        }

        return "Program " + index + "is set";
    }

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public String getAllProgrammes() {
        List<Program> programs = washingMachine.getPrograms();

        if (programs.isEmpty()) return "Programs are empty";

        StringBuilder programsDescription = new StringBuilder();
        int index = 0;

        for (Program program : programs) {
            programsDescription
                    .append("\n").append(index++).append(": ")
                    .append(program.toString());
        }

        return programsDescription.toString();
    }
}
