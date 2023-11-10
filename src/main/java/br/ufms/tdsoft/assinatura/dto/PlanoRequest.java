package br.ufms.tdsoft.assinatura.dto;

import java.math.BigDecimal;

public record PlanoRequest(BigDecimal valor, String descricao, String servicos, Long validadeDias) {
}
