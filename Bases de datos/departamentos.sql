set headsep |
ttitle 'Trabajadores departamentos|================================='

column nombre_dpto format A15 truncated heading 'Departamento'
column jefe format A15 heading 'Jefe'
column empleado format A10 heading 'Empleado'

break on nombre_dpto skip 1
compute count label 'Total participantes: ' of empleado on nombre_dpto

set pagesize 50
set linesize 50
set newpage 0

spool "C:\Users\david\Documents\DAM\Bases de datos\informe_departamentos"

select distinct departamento.nombre_dpto, departamento.dni as jefe, trabajar.dni as empleado 
from departamento, trabajar 
where departamento.codigo_dpto = trabajar.codigo_dpto 
order by departamento.nombre_dpto, departamento.dni;

ttitle off

spool off
