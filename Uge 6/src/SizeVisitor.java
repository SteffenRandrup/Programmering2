
public class SizeVisitor implements FileSystemVisitor<Integer>{

	@Override
	public Integer visitFile(FileNode f) {
		return f.getSize();
	}

	@Override
	public Integer visitDirectory(DirectoryNode d) {
		int totalSize = 0;
		for(FileSystemNode node : d){
			totalSize += node.accept(this);
		}
		return totalSize;
	}
}
