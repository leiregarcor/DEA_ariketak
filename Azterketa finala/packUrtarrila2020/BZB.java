package packUrtarrila2020;

    public class BZB {
        BinaryTreeNode<Integer> root;
        public void add(int v) {
            // Aurrebaldintza: v ez dago zuhaitzean.
            // Postbaldintza: v zuhaitzean txertatu da
            // Oharra: gogoratu txertaketaren ondorioz zenbait adabegiren numberOfNodes
            // atributua eguneratu beharko dela.
            BinaryTreeNode<Integer> berria = new BinaryTreeNode<>(v);
            if (root=null){
                root=berria;
                root.numberOfNodes= root.numberOfNodes+1;
            }
            else {
                BinaryTreeNode<Integer> unekoa= root;
                boolean txertatua= false;
                while (!txertatua){
                    unekoa.numberOfNodes= unekoa.numberOfNodes+1;
                    if (v< unekoa.data){
                        if (unekoa.left==null){
                            unekoa.left=berria;
                            txertatua=true;
                            //unekoa.numberOfNodes= unekoa.numberOfNodes+1;
                        }
                        else {
                            unekoa=unekoa.left;
                        }
                    }
                    else { //v>unekoa.data bada
                        if (unekoa.right==null){
                        unekoa.right=berria;
                        txertatua=true;
                        //unekoa.numberOfNodes= unekoa.numberOfNodes+1;
                        }
                        else {
                            unekoa=unekoa.right;
                        }
                    }
                }
            }
        }


        public void printTartea(int a, int b){
            // Azalpena: Idatzi irteera estandarrean a eta b tarteko balioa duten nodoen balioak
            // (a eta b barne) goranzko ordenan.
            // Oharra: Errekurtsiboki inplementatu eta soilik behar diren nodoak tratatu.

        }




        private static class BinaryTreeNode<T> {
            T data;
            BinaryTreeNode<T> left, right;
            int numberOfNodes;

            public BinaryTreeNode(T v) {
                data=v;
            }
        }
}
