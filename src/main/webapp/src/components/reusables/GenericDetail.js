import {useParams} from "react-router";
import useFetch from "../../hooks/useFetch";

const GenericDetail = ({DetailLayout, handleModify, handleDelete, url}) => {
    const {id} = useParams();

    const {data, error, isPending} = useFetch(url + id);

    return (
        <div className="blog-details">
            {isPending && <div>Loading...</div>}
            {error && <div>{error}</div>}
            {data &&
            <article>
                <DetailLayout item={data}/>
                <button className="example-custom-input" onClick={handleModify}>modify</button>
                <button className="example-custom-input" onClick={handleDelete}>delete</button>
                <button className="example-custom-input">back</button>
            </article>
            }
        </div>
    );
};

export default GenericDetail;