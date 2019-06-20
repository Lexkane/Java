public static async Future<Byte> readFirstByteAsync(String filePath) {
    Path path = Paths.get(filePath);
    AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);

    ByteBuffer buffer = ByteBuffer.allocate(100_000);
    await channel.read(buffer, 0, buffer, this);
    return buffer.get(0);
}