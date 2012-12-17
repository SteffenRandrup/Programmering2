Ændringer:
	SearchVisitor:

	Efter dine rettelser tror jeg, jeg havde totalt misforstået opgaven i første omgang, eller også er det det, der er sket nu. Jeg håber, jeg kan nå at få feedback på det.

		- Retur ændret til Void og bruges ikke længere
		- I stedet for at bruge node.accept(...) kaldes nu visitDirectory og visitFile direkte
		- Stierne til de enkelte filer gemmes i en lokal variabel i visitDirectory som
		overføres til en feltvariabel, når der er behov for udskrivning.

	WordCount:

		- WordCountTest har nu en LinkedBlockingQueue som sendes med som parameter til WordCount. Fra denne LBQ kan den så samle alle resultater ind og lægge dem sammen.
		- WordCount bruger add( tal ) til at indsætte i den medfølgende kø