import java.util.*;

public class DirectoryNode implements FileSystemNode, Iterable<FileSystemNode> {
	private String name;
	private List<FileSystemNode> nodes;

	public DirectoryNode(String n, List<FileSystemNode> c) {
		name = n;
		nodes = c;
	}

	public String getName() {
		return name;
	}

	public Iterator<FileSystemNode> iterator() {
		return nodes.iterator();
	}

	@Override
	public <T> T accept(FileSystemVisitor<T> v) {
		return v.visitDirectory(this);
	}

}