import CinemaListItem from "./CinemaListItem";
import GenericList from "../reusables/GenericList";
import {useHistory} from "react-router";
import useRoles from "../../hooks/useRoles";

const CinemaView = () => {
    const history = useHistory();
    const {isAdmin} = useRoles();

    function handleClick() {
        history.push("/cinema/add");
    }

    return (
        <div>
            <GenericList title="All Cinemas" ListItem={CinemaListItem} url={'http://localhost:8080/api/cinema'}/>
            {isAdmin && <button onClick={handleClick}>Add cinema</button>}
        </div>

    );
};

export default CinemaView;
