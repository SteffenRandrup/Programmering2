public class FileNode implements FileSystemNode {
	private String name;
	private int size;

	public FileNode(String n, int s) {
		name = n;
		size = s;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	@Override
	public <T> T accept(FileSystemVisitor<T> v) {
		return v.visitFile(this);
	}
}