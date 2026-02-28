#!/bin/bash

if [ -z "$1" ]; then
  echo "Usage: ./run.sh ClassName"
  exit 1
fi

CLASS_NAME=$1

# adiciona package automaticamente se não vier completo
if [[ "$CLASS_NAME" != *"."* ]]; then
  CLASS_NAME="app.$CLASS_NAME"
fi

animate() {
  local message=$1
  while true; do
    for dots in "." ".." "..."; do
      echo -ne "\r${message}${dots}"
      sleep 0.5
    done
  done
}

# -------- COMPILE --------
animate "Compiling" &
ANIM_PID=$!

javac -cp "lib/*" -d out src/main/java/app/*.java
JAVAC_STATUS=$?

kill $ANIM_PID
wait $ANIM_PID 2>/dev/null

# limpa linha e quebra corretamente
echo -ne "\r\033[K"
echo "Compiling... Done."
echo ""

if [ $JAVAC_STATUS -ne 0 ]; then
  echo "Compilation failed."
  exit 1
fi

# -------- RUN --------
echo "Running $CLASS_NAME..."
echo ""

java -cp "out:lib/*:src/main/resources" $CLASS_NAME
JAVA_STATUS=$?

echo ""
echo "Finished."

exit $JAVA_STATUS