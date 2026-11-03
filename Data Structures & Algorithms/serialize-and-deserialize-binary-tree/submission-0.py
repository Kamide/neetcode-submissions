import json


def node_to_cell(node: TreeNode | None) -> list | None:
    if node is None:
        return None

    return [node.val, node_to_cell(node.left), node_to_cell(node.right)]


def cell_to_node(cell: list | None) -> TreeNode | None:
    if cell is None:
        return None

    return TreeNode(cell[0], cell_to_node(cell[1]), cell_to_node(cell[2]))


class Codec:
    def serialize(self, root: TreeNode | None) -> str:
        return json.dumps(node_to_cell(root))

    def deserialize(self, data: str) -> TreeNode | None:
        return cell_to_node(json.loads(data))
