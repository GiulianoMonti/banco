package com.giulian.banco.service;

import com.giulian.banco.model.Client;

public interface IClientService {
    Client findClientByIdentification(String identification);

}
