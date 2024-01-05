package com.guilhermehns.vendas.rest.dto;


import com.guilhermehns.vendas.validation.NotEmptyList;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;

    @NotNull(message = "{campo.total-pedido.orbigatorio}")
    private BigDecimal total;

    @NotEmptyList(message = "{campo.itens-pedido.obrigatorio}")
    private List<ItemPedidoDTO> itens;

}
