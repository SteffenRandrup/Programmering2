public class SearchVisitor implements FileSystemVisitor<Void> {

	private String navn;
	private String path;

	public SearchVisitor(String s) {
		navn = s;
		path = "";
	}

	@Override
	public Void visitFile(FileNode f) {
		if (f.getName().contains(navn)) {
			System.out.println(path + "/" + f.getName());
		}
		return null;
	}

	@Override
	public Void visitDirectory(DirectoryNode d) {
 		path = path + "/" + d.getName();

		for (FileSystemNode Node : d) {
			node.accept(this);
		}
		return null;
	}
}
