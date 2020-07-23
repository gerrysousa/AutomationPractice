select top 10
    right(replicate('0',11) + convert(VARCHAR,E.CNPJ_CPF),11) as Cpf,
    right(replicate('0',6) + convert(VARCHAR,E.COD_CRESP),6) as Convenio
from dm01..EMPRESTIMO E with (nolock)
    inner join SCCDEM..ft01 with (nolock) on NRO_CONTRATO = CONTRATO_ID
where status = 'A' and COD_CRESP = '$codigoConvenio'  --and prconv = 4103
order by data_credito  desc