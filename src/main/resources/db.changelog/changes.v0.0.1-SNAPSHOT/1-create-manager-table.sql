<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                      http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd">
    <changeSet id="1" author="khudoshyn">
        <sqlFile path="10-create-manager-table.sql"
                 relativeToChangelogFile="true"
                 splitStatements="true"
                 dbms="mysql"/>
        <rollback>
            <sqlFile path="1-drop-manager-table.sql"
                     relativeToChangelogFile="true"
                     splitStatements="true"
                     dbms="mysql"/>
        </rollback>
    </changeSet>
</databaseChangeLog>