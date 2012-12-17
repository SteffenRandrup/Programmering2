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

		if(path.equals("")){
			path = d.getName();
		}
		
		String pathHolder = path;
		
		for (FileSystemNode node : d) {

			if (node.getClass().equals(DirectoryNode.class)) {
				
				path = pathHolder + "/" + ((DirectoryNode) node).getName();					
				visitDirectory((DirectoryNode) node);

			} else if (node.getClass().equals(FileNode.class)) {
				
				path = pathHolder;
				visitFile((FileNode) node);
				
			}
			
		}
		return null;
	}

}
