Скрипты рапускаются в следующем порядке:
1. CreateDateBase.sql
2. CreateTables.sql
3. CreateSequence.sql

Примеры команд:
1. psql -U postgres -f D:\GitProjects\relex_practice_project\practice_project\DB_Scripts\CreateDateBase.sql
2. psql -U postgres -d Active_citizen -f D:\GitProjects\relex_practice_project\practice_project\DB_Scripts\CreateTables.sql
3. psql -U postgres -d Active_citizen -f D:\GitProjects\relex_practice_project\practice_project\DB_Scripts\CreateSequence.sql

Комадны выполняются из "\PostgreSQL\9.3\bin"