import GenericView from "../reusables/GenericView";
import CinemaListItem from "./CinemaListItem";

const CinemaView = () => {
    return (
        <GenericView title="All Cinemas" ListItem={CinemaListItem} url={'http://localhost:8080/api/cinema'}/>
    );
};

export default CinemaView;
