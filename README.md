# Desafio Dito - Manipulação de Dados

Desafio da Empresa dito relacionada a um organizador de informações. Uma função que recebe informaçações de eventos e 
os agrupa por número da transação e por loja em ordem decrescente (timeline)

## Endpoints

    POST /api/v1/timeline

Usado para endpoint utilizado para mandar uma lista de eventos, por exemplo:

```json
{
    "events":[
       {
          "event":"comprou-produto",
          "timestamp":"2016-09-22T13:57:32.2311892-03:00",
          "custom_data":[
             {
                "key":"product_name",
                "value":"Camisa Azul"
             },
             {
                "key":"transaction_id",
                "value":"3029384"
             },
             {
                "key":"product_price",
                "value":100
             }
          ]
       },
       {
          "event":"comprou",
          "timestamp":"2016-09-22T13:57:31.2311892-03:00",
          "revenue":250,
          "custom_data":[
             {
                "key":"store_name",
                "value":"Patio Savassi"
             },
             {
                "key":"transaction_id",
                "value":"3029384"
             }
          ]
       },
       {
          "event":"comprou-produto",
          "timestamp":"2016-09-22T13:57:33.2311892-03:00",
          "custom_data":[
             {
                "key":"product_price",
                "value":150
             },
             {
                "key":"transaction_id",
                "value":"3029384"
             },
             {
                "key":"product_name",
                "value":"Calça Rosa"
             }
          ]
       },
       {
          "event":"comprou-produto",
          "timestamp":"2016-10-02T11:37:35.2300892-03:00",
          "custom_data":[
             {
                "key":"transaction_id",
                "value":"3409340"
             },
             {
                "key":"product_name",
                "value":"Tenis Preto"
             },
             {
                "key":"product_price",
                "value":120
             }
          ]
       },
       {
          "event":"comprou",
          "timestamp":"2016-10-02T11:37:31.2300892-03:00",
          "revenue":120,
          "custom_data":[
             {
                "key":"transaction_id",
                "value":"3409340"
             },
             {
                "key":"store_name",
                "value":"BH Shopping"
             }
          ]
       }
    ]
 }
```

Resultado: Eventos agrupados por ID de transação. Em que cada item corresponde a uma compra realizada em
um estabelicimento. As infomrações são ordenadas em ordem decrescente:

```json
{
    "timeline": [
        {
            "timestamp": "2016-10-02T14:37:31.2300892Z",
            "revenue": 120,
            "transaction_id": "3409340",
            "store_name": "BH Shopping",
            "products": [
                {
                    "name": "Tenis Preto",
                    "price": 120
                }
            ]
        },
        {
            "timestamp": "2016-09-22T16:57:31.2311892Z",
            "revenue": 250,
            "transaction_id": "3029384",
            "store_name": "Patio Savassi",
            "products": [
                {
                    "name": "Camisa Azul",
                    "price": 100
                },
                {
                    "name": "Calça Rosa",
                    "price": 150
                }
            ]
        }
    ]
}
```

## Tecnologias utilizadas:

* Java 8 com Spring Boot 2

### Referências

* [Fabric 8 Maven Plugin for Docker](https://dmp.fabric8.io/)

### 2020 - Lucas de Castro Oliveira