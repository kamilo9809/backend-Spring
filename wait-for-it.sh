#!/usr/bin/env bash
# wait-for-it.sh

set -e

host="$1"
shift
cmd="$@"

# Intentar conectar a MySQL usando el cliente de línea de comandos
until mysql -h "$host" -u "$MYSQL_USER" -p"$MYSQL_PASSWORD" -e "SELECT 1" > /dev/null 2>&1; do
  >&2 echo "Waiting for MySQL at $host to be available..."
  sleep 1
done

>&2 echo "MySQL is up - executing command"
exec $cmd
