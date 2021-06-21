import HallListItem from "./HallListItem";
import GenericList from "../reusables/GenericList";
import {useHistory} from "react-router";

const HallView = ({parent: cinema}) => {
    const history = useHistory();

    function handleClick() {
        history.push(`/hall/add/${cinema.id}`);
    }

    return (
        <div>
            <GenericList title={"All halls of cinema: " + cinema.name} ListItem={HallListItem} url={'http://localhost:8080/api/hall?cinemaId=' + cinema.id} parentId={cinema.id}/>
            <button onClick={handleClick}>Add Hall</button>
        </div>

    );
};

export default HallView;
