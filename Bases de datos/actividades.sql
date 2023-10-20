set headsep |

ttitle 'Actividades realizadas por clientes|================================='

column nombre_actividad format A15 truncated heading 'Actividad'
column lugar format A15 heading 'Lugar'
column dni_cliente format A10 heading 'DNI Clientes'

break on nombre_actividad skip 1
compute count label 'Total participantes: ' of dni_cliente on nombre_actividad

set pagesize 50
set linesize 50
set newpage 0

spool "C:\Users\david\Documents\DAM\Bases de datos\informe_actividades"

SELECT actividad.nombre_actividad, actividad.lugar, participar.dni_cliente
FROM actividad, participar
WHERE actividad.codigo_actividad = participar.codigo_actividad
ORDER BY actividad.nombre_actividad, actividad.lugar;

ttitle off

spool off