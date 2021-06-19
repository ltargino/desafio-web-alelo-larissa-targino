#language: pt
Funcionalidade: Pesquisa de cep e logradouro no site dos correios

  @PesquisarCEP
  Cenario: Realizar a pesquisa de um CEP no site dos correios
    Dado que eu acesse o site dos correios
    Quando eu realizar a pesquisa por "<cep>"
    E clicar no botao Buscar
    Então devera ser possivel fazer output das informações retornadas

    Exemplos:
      | cep |
      | 58073447 |
      | 58073448 |

  @PesquisarLogradouro
  Cenario: Realizar a pesquisa de um logradouro que retorne mais de um resultado no site dos correios
    Dado que eu acesse o site dos correios
    Quando eu realizar a pesquisa por "<logradouro>"
    E clicar no botao Buscar
    Então devera ser possivel fazer output das informações retornadas

    Exemplos:
      | logradouro |
      | maria geni |
      | jose ary   |