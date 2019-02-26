FROM mysql

# Add a database
ENV MYSQL_DATABASE world

# Copy database .sql file to be ran on start-up
COPY world_db/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD example