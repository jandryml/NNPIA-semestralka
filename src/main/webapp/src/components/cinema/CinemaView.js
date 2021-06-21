import CinemaListItem from "./CinemaListItem";
import GenericList from "../reusables/GenericList";
import {useHistory} from "react-router";

const CinemaView = () => {
    const history = useHistory();

    function handleClick() {
        history.push("/cinema/add");
    }

    return (
        <div>
            <GenericList title="All Cinemas" ListItem={CinemaListItem} url={'http://localhost:8080/api/cinema'}/>
            <button onClick={handleClick}>Add cinema</button>
        </div>

    );
};

export default CinemaView;
