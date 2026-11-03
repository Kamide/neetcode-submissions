type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Codec {
    serialize(root: TNM): string {
        return JSON.stringify(root);
    }

    deserialize(data: string): TNM {
        return JSON.parse(data);
    }
}
