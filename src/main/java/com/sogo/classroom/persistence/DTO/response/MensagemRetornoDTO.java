package com.sogo.classroom.persistence.DTO.response;

import java.io.Serializable;

public class MensagemRetornoDTO implements Serializable {

    private static final long serialVersionUID = -3205145993738065092L;

    private String mensagem;

    public MensagemRetornoDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
