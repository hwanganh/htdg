ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"
echo "---------File is compiling...---------"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java
echo '--------Main.java is running!!--------'
java -cp "$BUILD_DIR" Main
echo '--------Main.java is closing..--------'
sleep 5
echo '---------------Goodbye!---------------'
