FROM postgres

ADD initial.sql /docker-entrypoint-initdb.d/initial.sql
RUN chmod 755 /docker-entrypoint-initdb.d/initial.sql